package com.cg.orms.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.orms.entities.CandidatePersonal;
import com.cg.orms.entities.CandidateQualifications;
import com.cg.orms.entities.CandidateWorkHistory;
import com.cg.orms.entities.JobApplied;
import com.cg.orms.entities.JobRequirements;
import com.cg.orms.entities.Login;
import com.cg.orms.exception.RecruitmentException;
import com.cg.orms.service.RecruitmentService;
import com.cg.orms.util.Constant;
import com.cg.orms.util.DateUtility;

@Controller
public class RecruitmentController {
	@Autowired
	RecruitmentService service;
	final String LOGIN = "login";
	final String MESSAGE = "message";
	final String ERROR = "error";
	final String ADDRESUME = "addresume";
	final String MODIFYRESUME = "modifyresume";
	final String JOBS = "jobs";
	final String CANDIDATE = "candidate";
	final String SIGNUP = "signup";
	final String USERS = "users";
	final String CANDIDATE_PERSONAL_DETAILS="candPers";
	final String CANDIDATE_QUALIFICATION_DETAILS="candQual";
	final String CANDIDATE_WORK_HISTORY_DETAILS="candWork";
	final String JOB_REQUIREMENTS_BY_QUALIFICATION="jobRequirements1";
	final String JOB_REQUIREMENTS_BY_LOCATION="jobRequirements2";
	final String JOB_REQUIREMENTS_BY_POSITION="jobRequirements3";
	final String JOB_REQUIREMENTS_BY_EXPERIENCE="jobRequirements4";
	String candidateId = null;

	/**
	 * <p>shows login form to the user</p>
	 * 
	 * From home page when you click on log in user is directed here.
	 * 
	 * @param model
	 * @return login
	 */
	@RequestMapping("/showloginform.htm")
	public String showLoginPage(Model model) {
		model.addAttribute(LOGIN, new Login());
		return LOGIN;
	}

	/**
	 * <p>signs out user</p> 
	 * 
	 * When ever user selects Sign out he will be directed here
	 * 
	 * @param model
	 * @return LOGIN.html
	 */
	@RequestMapping("/signout.htm")
	public String signOut(Model model) {
		Login login = new Login();
		login.setLoginId(candidateId);
		candidateId = null;
		model.addAttribute(LOGIN, login);
		return LOGIN;
	}

	/**
	 * Fetching the entered login-Id and Password from login.jsp and validating
	 * the login credentials by checking its availability in database and
	 * redirecting the program to appropriate jsp page depending upon the type
	 * of user
	 * 
	 * @param model
	 * @param loginId
	 * @param password
	 * @return success.jsp
	 * @throws RecruitmentException
	 */
	@RequestMapping(value = "/checklogin.htm", method = RequestMethod.POST)
	public String login(Model model, @RequestParam("loginId") String loginId,
			@RequestParam("password") String password) {
		Login login = new Login();
		login.setLoginId(loginId);
		login.setPassword(password);
		try {
			if (!service.validateLoginDetails(login.getLoginId(),
					login.getPassword())) {
				model.addAttribute(MESSAGE, "Invalid Login Details");
				return LOGIN;
			} else {
				login.setType(service.getLoginDetails(login.getLoginId())
						.getType());
				model.addAttribute("loginId", login.getLoginId());
				if ("User".equals(login.getType())) {
					candidateId = login.getLoginId();
					return "candidate";
				} else if ("Company".equals(login.getType()))
					return "company";
				else
					return "admin";
			}
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
	}

	/**
	 * Sending the list of, type of users to signup.jsp
	 * 
	 * @param model
	 * @return signup.jsp
	 */
	@RequestMapping("/showsignupform.htm")
	public String showsignupPage(Model model) {
		model.addAttribute(USERS, Constant.getUsers());
		model.addAttribute(LOGIN, new Login());
		return SIGNUP;
	}

	/**
	 * Fetching the signup credentials from signup.jsp and inserting them into
	 * database
	 * 
	 * @param model
	 * @param login
	 * @param result
	 * @exception RecruitmentException
	 * @return success.jsp/error.jsp
	 */
	@RequestMapping(value = "/checksignup.htm", method = RequestMethod.POST)
	public String signup(Model model,
			@ModelAttribute(LOGIN) @Valid Login login, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute(USERS, Constant.getUsers());
			model.addAttribute(LOGIN, new Login());
			return SIGNUP;
		}
		try {
			if (service.getLoginDetails(login.getLoginId()) != null) {
				model.addAttribute(USERS, Constant.getUsers());
				model.addAttribute(LOGIN, new Login());
				model.addAttribute(MESSAGE, "UserId Already Taken");
				return SIGNUP;
			} else
				service.signUp(login);
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
		return LOGIN;
	}

	/**
	 * <p>shows add resume form to candidate<p>x
	 * 
	 * When the user selects add resume from candidate.jsp the page is
	 * redirected to addresume.jsp
	 * 
	 * @param model
	 * @return addresume.jsp
	 */
	@RequestMapping("/addresumeform.htm")
	public String showCandidateAddResumeForm(Model model) {
		return ADDRESUME;
	}

	/**
	 * When the user clicks on add Personal details in addresume.jsp he is
	 * redirected here and an object of personal details is sent to
	 * addresume.jsp
	 * 
	 * @param model
	 * @return addresume.jsp
	 */
	@RequestMapping("/addpersonalform.htm")
	public String addPersonalForm(Model model) {

		try {
			service.getCandidatePersonalDetails(candidateId);
			model.addAttribute(CANDIDATE_PERSONAL_DETAILS, null);
			model.addAttribute(MESSAGE, "Personal Details already inserted,modify them");
			return ADDRESUME;
		} catch (RecruitmentException exception) {
			model.addAttribute(CANDIDATE_PERSONAL_DETAILS, new CandidatePersonal());
			model.addAttribute("currentDate", Date.valueOf(LocalDate.now()));
			return ADDRESUME;
		}
	}

	/**
	 * Onclicking save personal details in addresume.jsp the page is directed
	 * here and the personal details are saved and page is sent to addresume.jsp
	 * 
	 * @param model
	 * @param candidatePersonal
	 * @exception RecruitmentException
	 * @return addresume.jsp
	 */
	@RequestMapping(value = "/savepersonal.htm"/* , method = RequestMethod.POST */)
	public String savePersonalDetails(Model model,
			@ModelAttribute(CANDIDATE_PERSONAL_DETAILS) CandidatePersonal candidatePersonal) {
		try {
			Date dateFromPage = candidatePersonal.getDob();
			candidatePersonal.setDob(DateUtility.parseDate(dateFromPage));
			candidatePersonal.setCandidateId(candidateId);
			service.insertCandidatePersonalDetails(candidatePersonal);
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
		model.addAttribute(CANDIDATE_PERSONAL_DETAILS, null);
		model.addAttribute(MESSAGE,
				"Personal Details successfully inserted !!!");
		return ADDRESUME;
	}

	/**
	 * On clicking add Qualificationdetails in addresume.jsp the page is
	 * directed here and the personal details are saved and now to add
	 * qualifications an object of candidateQualifications is sent to
	 * addresume.jsp
	 * 
	 * @param model
	 * @return addresume.jsp
	 */
	@RequestMapping("/addqualform.htm")
	public String showAddQualificationForm(Model model) {
		try {
			service.getCandidateQualificationDetails(candidateId);
			model.addAttribute(CANDIDATE_QUALIFICATION_DETAILS, null);
			model.addAttribute(MESSAGE, "Qualification Details already inserted,modify them");
			return ADDRESUME;
		} catch (RecruitmentException exception) {
			model.addAttribute("qualifications", Constant.getQualifications());
			model.addAttribute(CANDIDATE_QUALIFICATION_DETAILS, new CandidateQualifications());
			model.addAttribute("currentYear", LocalDate.now().getYear());
			return ADDRESUME;
		}
	}

	/**
	 * Onclicking save QualificationDetails details in addresume.jsp the page is
	 * directed here and the Qualification details are saved and page is
	 * directed to addresume.jsp
	 * 
	 * @param model
	 * @exception RecruitmentException
	 * @return addresume.jsp
	 */
	@RequestMapping(value = "/savequal.htm", method = RequestMethod.POST)
	public String saveQualificationDetails(
			Model model,
			@ModelAttribute(CANDIDATE_QUALIFICATION_DETAILS) CandidateQualifications candidateQualifications) {
		candidateQualifications.setCandidateId(candidateId);
		try {
			service.insertCandidateQualificationDetails(candidateQualifications);
			model.addAttribute(MESSAGE,
					"Qualification Details successfully inserted !!!");
			model.addAttribute(CANDIDATE_QUALIFICATION_DETAILS, null);
			return ADDRESUME;
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
	}

	/**
	 * On clicking add workHistory in addresume.jsp the page is directed here
	 * and and to add work history an object of candidateWorkHistory is sent to
	 * addresume.jsp
	 * 
	 * @param model
	 * @return addresume.jsp
	 */
	@RequestMapping("/addworkform.htm")
	public String showAddWorkHistoryForm(Model model) {
		try {
			service.getCandidateWorkHistoryDetails(candidateId);
			model.addAttribute(CANDIDATE_WORK_HISTORY_DETAILS, null);
			model.addAttribute(MESSAGE, "Work History Details already inserted,modify them");
			return ADDRESUME;
		} catch (RecruitmentException exception) {
			model.addAttribute(CANDIDATE_WORK_HISTORY_DETAILS, new CandidateWorkHistory());
			model.addAttribute("currentDate", Date.valueOf(LocalDate.now()));
			return ADDRESUME;
		}
	}

	/**
	 * On clicking save work history in addresume.jsp the page is directed here
	 * and the work history is saved.
	 * 
	 * @param model
	 * @param candidateWorkHistory
	 * @exception RecruitmentException
	 * @return addresume.jsp
	 */
	@RequestMapping(value = "/saveworkhist.htm", method = RequestMethod.POST)
	public String saveWorkHistoryDetails(
			Model model,
			@ModelAttribute(CANDIDATE_WORK_HISTORY_DETAILS) CandidateWorkHistory candidateWorkHistory) {
		Date employmentFrom = candidateWorkHistory.getEmploymentFrom();
		Date employmentTo = candidateWorkHistory.getEmploymentTo();
		candidateWorkHistory.setEmploymentFrom(DateUtility
				.parseDate(employmentFrom));
		candidateWorkHistory.setEmploymentTo(DateUtility
				.parseDate(employmentTo));
		candidateWorkHistory.setCandidateId(candidateId);
		try {
			service.insertCandidateWorkHistoryDetails(candidateWorkHistory);
			model.addAttribute(MESSAGE,
					"Work History Details successfully inserted !!!");
			model.addAttribute(CANDIDATE_WORK_HISTORY_DETAILS, null);
			return ADDRESUME;
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
	}

	/**
	 * When selected modify resume in candidate.jsp page is directed here
	 * 
	 * @param model
	 * @return modifyresume.jsp
	 */
	@RequestMapping("/modifyresumeform.htm")
	public String showCandidateModifyResumeForm(Model model) {
		return MODIFYRESUME;
	}

	@RequestMapping("/backtocandidate.htm")
	public String backToCandidate(Model model) {
		return "candidate";
	}

	/**
	 * When modify personal details is selected the the page is directed here
	 * and the personal details are fetched from data base and directed to
	 * modifyresume.jsp
	 *
	 * @param model
	 * @return modifyresume.jsp
	 * @throws RecruitmentException
	 */
	@RequestMapping("/modifypersonalform.htm")
	public String modifyPersonalForm(Model model) {
		try {
			CandidatePersonal candidatePersonal = service
					.getCandidatePersonalDetails(candidateId);
			model.addAttribute(CANDIDATE_PERSONAL_DETAILS, candidatePersonal);
			model.addAttribute("currentDate", Date.valueOf(LocalDate.now()));
		} catch (RecruitmentException exception) {
			model.addAttribute(MESSAGE, "No Personal details found,add them ");
			return MODIFYRESUME;
		}
		return MODIFYRESUME;
	}

	/**
	 * When the personal details are updated and saved the page is directed here
	 * and the modified details are saved and is directed to modifyresume.jsp
	 * 
	 * @param model
	 * @param candidatePersonal
	 * @return modifyresume.jsp
	 * @throws RecruitmentException
	 */
	@RequestMapping(value = "/modifypersonal.htm", method = RequestMethod.POST)
	public String modifyPersonal(
			Model model,
			@ModelAttribute(CANDIDATE_PERSONAL_DETAILS) CandidatePersonal candidatePersonalDetails) {
		Date dateOfBirth = candidatePersonalDetails.getDob();
		candidatePersonalDetails.setDob(DateUtility.parseDate(dateOfBirth));
		candidatePersonalDetails.setCandidateId(candidateId);
		try {
			service.modifyCandidatePersonalDetails(candidatePersonalDetails);
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
		model.addAttribute(MESSAGE,
				"Personal Details successfully modified !!!");
		model.addAttribute(CANDIDATE_PERSONAL_DETAILS, null);
		return MODIFYRESUME;
	}

	/**
	 * When modify Qualification details is selected then the page is directed
	 * here and the Qualification details are fetched from data base and
	 * directed to modifyresume.jsp
	 * 
	 * @param model
	 * @return modifyresume.jsp
	 * @throws RecruitmentException
	 */
	@RequestMapping("/modifyqualform.htm")
	public String modifyQualificationForm(Model model) {
		try {
			CandidateQualifications candidateQualification = service
					.getCandidateQualificationDetails(candidateId);
			model.addAttribute(CANDIDATE_QUALIFICATION_DETAILS, candidateQualification);
			model.addAttribute("currentYear", LocalDate.now().getYear());
			model.addAttribute("qualifications", Constant.getQualifications());
		} catch (RecruitmentException exception) {
			model.addAttribute(MESSAGE,
					"No Qualification details found,add them ");
			return MODIFYRESUME;
		}
		return MODIFYRESUME;
	}

	/**
	 * When the Qualification details are updated and saved the page is directed
	 * here and the modified details are saved and is directed to
	 * modifyresume.jsp
	 * 
	 * @param model
	 * @param candidateQualifications
	 * @return modifyresume.jsp
	 * @throws RecruitmentException
	 */
	@RequestMapping(value = "/modifyqual.htm", method = RequestMethod.POST)
	public String modifyQualifications(
			Model model,
			@ModelAttribute(CANDIDATE_QUALIFICATION_DETAILS) CandidateQualifications candidateQualificationDetails) {
		candidateQualificationDetails.setCandidateId(candidateId);
		try {
			service.modifyCandidateQualificationDetails(candidateQualificationDetails);
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
		}
		model.addAttribute(MESSAGE,
				"Qualification Details successfully modified !!!");
		model.addAttribute(CANDIDATE_QUALIFICATION_DETAILS, null);
		return MODIFYRESUME;
	}

	/**
	 * When modify Work history is selected then the page is directed here and
	 * the Work history details are fetched from data base and directed to
	 * modifyresume.jsp
	 * 
	 * @param model
	 * @return modifyresume.jsp
	 * @throws RecruitmentException
	 */
	@RequestMapping("/modifyworkhistform.htm")
	public String modifyWorkHistoryForm(Model model) {
		try {
			CandidateWorkHistory candidateWorkHistory = service
					.getCandidateWorkHistoryDetails(candidateId);
			model.addAttribute(CANDIDATE_WORK_HISTORY_DETAILS, candidateWorkHistory);
		} catch (RecruitmentException exception) {
			model.addAttribute(MESSAGE,
					"No Work History details found,add them ");
			return MODIFYRESUME;
		}
		model.addAttribute("currentDate", Date.valueOf(LocalDate.now()));
		return MODIFYRESUME;
	}

	/**
	 * When the Work History details are updated and saved the page is directed
	 * here and the modified details are saved and is directed to
	 * modifyresume.jsp
	 * 
	 * @param model
	 * @param candidateWorkHistoryDetails
	 * @return modifyresume.jsp
	 * @throws RecruitmentException
	 */
	@RequestMapping(value = "/modifyworkhist.htm", method = RequestMethod.POST)
	public String modifyQualifications(
			Model model,
			@ModelAttribute(CANDIDATE_WORK_HISTORY_DETAILS) CandidateWorkHistory candidateWorkHistoryDetails) {
		Date employmentFrom = candidateWorkHistoryDetails.getEmploymentFrom();
		Date employmentTo = candidateWorkHistoryDetails.getEmploymentTo();
		candidateWorkHistoryDetails.setEmploymentFrom(DateUtility
				.parseDate(employmentFrom));
		candidateWorkHistoryDetails.setEmploymentTo(DateUtility
				.parseDate(employmentTo));
		candidateWorkHistoryDetails.setCandidateId(candidateId);
		try {
			service.modifyCandidateWorkHistoryDetails(candidateWorkHistoryDetails);
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
		model.addAttribute(MESSAGE,
				"Work History Details successfully modified !!!");
		model.addAttribute(CANDIDATE_WORK_HISTORY_DETAILS, null);
		return MODIFYRESUME;
	}

	/**
	 * When user selects search jobs from his home page he will be directed here
	 * and is sent to searchjobs.jsp
	 * 
	 * @param model
	 * @return searchjobs.jsp
	 */
	@RequestMapping("/search.htm")
	public String searchBy(Model model) {
		model.addAttribute(JOB_REQUIREMENTS_BY_QUALIFICATION, new JobRequirements());
		model.addAttribute(JOB_REQUIREMENTS_BY_POSITION, new JobRequirements());
		model.addAttribute(JOB_REQUIREMENTS_BY_EXPERIENCE, new JobRequirements());
		model.addAttribute(JOB_REQUIREMENTS_BY_LOCATION, new JobRequirements());
		model.addAttribute("qualifications", Constant.getQualifications());
		model.addAttribute("cities", Constant.getCities());
		return "searchjobs";
	}

	/**
	 * When user clicks on search jobs by qualification in searchjobs.jsp he
	 * will be directed here and is sent to jobs.jsp where a list of jobs
	 * matching his selected criteria will be displayed.
	 * 
	 * @param jobRequirements
	 * @param model
	 * @return jobs.jsp
	 */
	@RequestMapping(value = "/byqualification.htm", method = RequestMethod.POST)
	public String searchByQualification(
			@ModelAttribute(JOB_REQUIREMENTS_BY_QUALIFICATION) JobRequirements jobRequirements,
			Model model) {
		String qualificationRequired = jobRequirements
				.getQualificationRequired();
		List<JobRequirements> jobs=null;
		try {
			jobs = service.getJobsByQualification(qualificationRequired);
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
		model.addAttribute(JOBS, jobs);
		return JOBS;
	}

	/**
	 * When user clicks on search jobs by position in searchjobs.jsp he will be
	 * directed here and is sent to jobs.jsp where a list of jobs matching his
	 * selected criteria will be displayed.
	 * 
	 * @param jobRequirements
	 * @param model
	 * @return jobs.jsp
	 */
	@RequestMapping(value = "/byposition.htm", method = RequestMethod.POST)
	public String searchByPosition(
			@ModelAttribute(JOB_REQUIREMENTS_BY_POSITION) JobRequirements jobRequirements,
			Model model) {
		String positionRequired = jobRequirements.getPositionRequired();
		List<JobRequirements> jobs=null;
		try {
			jobs = service.getJobsByPosition(positionRequired);
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
		model.addAttribute(JOBS, jobs);
		return JOBS;

	}

	/**
	 * When user clicks on search jobs by experience in searchjobs.jsp he will
	 * be directed here and is sent to jobs.jsp where a list of jobs matching
	 * his selected criteria will be displayed.
	 * 
	 * @param jobRequirements
	 * @param model
	 * @return jobs.jsp
	 */
	@RequestMapping(value = "/byexperience.htm", method = RequestMethod.POST)
	public String searchByExperience(
			@ModelAttribute(JOB_REQUIREMENTS_BY_EXPERIENCE) JobRequirements jobRequirements,
			Model model) {
		int experienceRequired = jobRequirements.getExperienceRequired();
		List<JobRequirements> jobs=null;
		try {
			jobs = service.getJobsByExperience(experienceRequired);
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
		model.addAttribute(JOBS, jobs);
		return JOBS;
	}

	/**
	 * When user clicks on search jobs by location in searchjobs.jsp he will be
	 * directed here and is sent to jobs.jsp where a list of jobs matching his
	 * selected criteria will be displayed.
	 * 
	 * @param jobRequirements
	 * @param model
	 * @return jobs.jsp
	 */
	@RequestMapping(value = "/bylocation.htm", method = RequestMethod.POST)
	public String searchByLocation(
			@ModelAttribute(JOB_REQUIREMENTS_BY_LOCATION) JobRequirements jobRequirements,
			Model model) {
		String jobLocation = jobRequirements.getJobLocation();
		List<JobRequirements> jobs=null;
		try {
			jobs = service.getJobsByLocation(jobLocation);
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
		model.addAttribute(JOBS, jobs);
		return JOBS;
	}

	/**
	 * When in jobs.jsp and the list of jobs is displayed and he selects apply,
	 * program is directed here and the job applied will be saved .
	 * 
	 * @param jobID
	 * @param companyId
	 * @param model
	 * @return candidate.jsp
	 */
	@RequestMapping("/apply.htm")
	public String applyForJob(@RequestParam("jobID") String jobID,
			@RequestParam("companyId") String companyId, Model model) {
		JobApplied jobApplied = new JobApplied();
		jobApplied.setCandidateId(candidateId);
		jobApplied.setJobId(jobID);
		jobApplied.setCompId(companyId);
		try {
			service.insertJobApplied(jobApplied);
			model.addAttribute(MESSAGE,
					"Successfully applied for the job with ID:" + jobID);
		} catch (RecruitmentException exception) {
			model.addAttribute(ERROR, exception.getMessage());
			return ERROR;
		}
		return CANDIDATE;
	}
}
