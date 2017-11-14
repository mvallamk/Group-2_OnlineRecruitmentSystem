create table Company_Master (
company_id varchar2(5) primary key,
company_name varchar2(30),
company_address varchar2(100),
contact_person varchar2(25),
email_id varchar2(30),
contact_number varchar2(10));

create table Job_Requirements (
job_id varchar2(5) primary key,
company_id varchar2(5) references Company_Master(company_id),
position_required varchar2(20),
numbers_required Number(2),
Experience_required Number(2),
Qualification_required varchar2(20),
job_location varchar2(25),
job_description varchar2(100));

create table CandidatePersonal (
candidateId varchar2(5)primary key,
candidateName varchar2(20),
address varchar2(100),
dob date,
emailId varchar2(30),
contactNumber varchar2(10),
maritalStatus varchar2(15),
gender varchar2(10),
passportNumber varchar2(15));

create table candidatequalifications (
candidate varchar2(5)primary key,
qualificationName varchar2(30),
specializationArea varchar2(30),
collegeName varchar2(25),
universityName varchar2(30),
yearOfPassing varchar2(4),
percentage number(5,2)
);

create table candidateworkhistory (

candidateId varchar2(5)primary key,
whichEmployer varchar2(10),
contactPerson varchar2(25),
positionHeld varchar2(20),
companyName varchar2(20),
employmentFrom date,
employmentTo date,
reasonForLeaving varchar2(100),
responsibilities varchar2(150),
hrRepName varchar2(20),
hrRepContactNumber varchar2(10));


create table Job_Applied (
job_id varchar2(5) references Job_Requirements(job_id),
candidate_id varchar2(5) references candidate_personal (candidate_id));



CREATE TABLE Hire_Details(job_id varchar2(5) references Job_Requirements(job_id),
candidate_id varchar2(5) references candidate_personal (candidate_id), hire_Date date,
company_id varchar2(5) references Company_Master(company_id))

INSERT INTO CandidatePersonal values ('999','male','bangalore,karnataka','manoj','9705867814','16-NOV-1995','manoj@gmail.com','unmarried','123456A!');
INSERT INTO CandidatePersonal values ('998','male','pune,maharastra','AKASH','9246100110','01-JAN-1994','akash@gmail.com','married','123416A!');
INSERT INTO CandidatePersonal values ('997','male','bangalore,karnataka','mohit','9705987814','16-SEP-1995','mohit@gmail.com','unmarried','123556A!');
INSERT INTO CandidatePersonal values ('981','male','GURGAON,DELHI','kaustav','9705987914','16-DEC-1994','kaustav@gmail.com','married','123456A!');

INSERT INTO CandidateQualifications values ('999','bits',98.3,'SSC','PHYSICS','BITS-PILANI','05-JUN-2017');
INSERT INTO CandidateQualifications values ('999','IIT',98.3,'BE','EEE','IIT-DELHI','05-AUG-2017');
INSERT INTO CandidateQualifications values ('998','NIT',98.3,'Diploma','Maths','NIT-SURATKAL','05-JUL-2017');
INSERT INTO CandidateQualifications values ('997','BITS',98.3,'PG','BIO-MECHANICS','BITS-DUBAI','05-MAR-2016');
INSERT INTO CandidateQualifications values ('981','MIT',98.3,'HSC','BODY-BUILDING','MASSACHUSETTS','03-MAR-2015');

INSERT INTO CandidateWorkHistory values ('999','EA-SPORTS','DANIEL','01-JAN-2001','31-DEC-2015','9705867814','HUGH','SeniorSoftwareEngineer','Personal Reasons','TeamLead','Bala');
INSERT INTO CandidateWorkHistory values ('999','DreamWorks','HITLER','01-JAN-2002','31-DEC-2017','9246100100','PHILL','Manager','Personal Reasons','TeamLead','Sandeep');
INSERT INTO CandidateWorkHistory values ('998','Math-Works','GANDHI','01-JAN-2006','31-DEC-2015','9705867814','KOHLI','SoftwareEngineer','Personal Reasons','DEVELOPER','NAREN');
INSERT INTO CandidateWorkHistory values ('998','MATLAB','MUSSOLINI','01-JAN-2007','31-DEC-2010','9705867814','DHONI','SeniorAnalyst','Personal Reasons','Support','Adith');
INSERT INTO CandidateWorkHistory values ('997','BENZ','MITTAL','01-JAN-2008','31-DEC-2011','9705867814','MARK','SeniorSoftwareEngineer','Personal Reasons','TeamLead','MANOJ');
INSERT INTO CandidateWorkHistory values ('997','ROLLS-ROYCE','GADDAFI','01-JAN-2004','31-DEC-2009','9705867814','HUGH','SoftwareEngineer','Personal Reasons','TeamLead','SHUBHAM');
INSERT INTO CandidateWorkHistory values ('981','FREAK-OUT','BILL','01-JAN-2006','31-DEC-2016','9705867814','DAN','Manager','Personal Reasons','TeamLead','PRATEEK');
INSERT INTO CandidateWorkHistory values ('981','SWEAT-IT','TRUMPH','01-JAN-2002','31-DEC-2008','9705867814','GOKU','SeniorAnalyst','Personal Reasons','TeamLead','BANSAL');


INSERT INTO job_requirements values ('51','101',5,'competitive environment','Pune','3','SoftwareEngineer','HSC');
INSERT INTO job_requirements values ('52','102',7,'competitive environment','Chennai','3','SeniorSoftwareEngineer','SSC');
INSERT INTO job_requirements values ('53','103',8,'competitive environment','Mumbai','3','SeniorAnalyst','BE');
INSERT INTO job_requirements values ('54','104',10,'competitive environment','Hyderabad','3','SoftwareEngineer','Diploma');
INSERT INTO job_requirements values ('55','105',15,'competitive environment','Bangalore','3','SeniorAnalyst','PG');
INSERT INTO job_requirements values ('56','106',12,'competitive environment','Pune','3','SoftwareEngineer','PG');
INSERT INTO job_requirements values ('57','107',3,'competitive environment','Chennai','3','Manager','Diploma');
INSERT INTO job_requirements values ('58','108',7,'competitive environment','Mumbai','3','SoftwareEngineer','BE');
INSERT INTO job_requirements values ('59','109',6,'competitive environment','Hyderabad','3','Manager','HSC');
INSERT INTO job_requirements values ('60','110',4,'competitive environment','Bangalore','3','SeniorSoftwareEngineer','SSC');