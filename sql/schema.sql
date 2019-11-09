-- 1.
create table MEDICAL_FACILITIES
(
    FACILITY_ID    NUMBER        not null
        constraint MEDICAL_FACILITIES_PK
            primary key,
    NAME           VARCHAR2(255) not null,
    CLASSIFICATION VARCHAR2(255) not null,
    ADDRESS        VARCHAR2(255) not null,
    CAPACITY       VARCHAR2(255) not null
)
/

-- 2.
create table PATIENTS
(
    PATIENT_ID      NUMBER,
    FIRSTNAME       VARCHAR2(255),
    LASTNAME        VARCHAR2(255) not null,
    DOB             DATE          not null,
    PHONE           VARCHAR2(255),
    ADDRESS_COUNTRY VARCHAR2(255),
    ADDRESS_STATE   VARCHAR2(255),
    ADDRESS_CITY    VARCHAR2(255) not null,
    ADDRESS_ZIP     NUMBER,
    PRIORITY_STATUS VARCHAR2(255),
    TREATMENT_TIME  DATE,
    constraint PETIENTS_PK
        primary key (LASTNAME, DOB)
)
/

create sequence patient_ID_SEQ
    nocache
/
create trigger patient_id_TRIGGER
    before insert
    on patients
    for each row
    when (NEW.PATIENT_ID is null)
begin
    select patient_ID_SEQ.nextval into :new.patient_id from dual;

end patient_id_TRIGGER;
/



-- 3.
create table patient_has_facility
(
  facility_id number not null
     constraint FACILITY_ID_fk
        references MEDICAL_FACILITIES
           on delete cascade,
  dob date not null,
  name varchar2(255) not null,
  constraint patient_has_facility_pk
     primary key (facility_id, dob, name),
  constraint NAME_DOB_fk
     foreign key (name, dob) references PATIENTS
        on delete cascade
)
/

-- 4.
create table check_ins
(
  name varchar2(255) not null,
  dob date not null,
  start_time date not null,
  end_time date,
  constraint check_ins_pk
     primary key (name, dob, start_time),
  constraint PHF_NAME_DOB_fk
     foreign key (name, dob) references PATIENTS
        on delete cascade
)
/

-- 5.
create table symptoms
(
  name varchar2(255) not null,
  sym_code varchar2(255) not null
     constraint symptoms_pk
        primary key
)
/

-- 6.
create table severities
(
  value number not null,
  name varchar2(255) not null,
  scale varchar2(255) not null,
  constraint severities_pk
     primary key (value, name, scale)
)
/

-- 7.
create table patient_has_sym_serverity
(
  sym_code varchar2(255) not null
     constraint PHSE_SYM_CODE_fk
        references SYMPTOMS
           on delete cascade,
  value number not null,
  sname varchar2(255) not null,
  scale varchar2(255) not null,
  name varchar2(255) not null,
  dob date not null,
  duration float not null,
  cause_incident varchar2(255) not null,
  first_occurrence char(1) default 0 not null,
  constraint PATIENT_HAS_SYM_SEVERITY_pk
     primary key (sym_code, value, sname, scale, name, dob),
  constraint PHSE_PATIENT_fk
     foreign key (name, dob) references PATIENTS
        on delete cascade,
  constraint PHSE_SEVERITY_fk
     foreign key (value, sname, scale) references SEVERITIES
        on delete cascade
)
/

-- 8.
create table body_parts
(
  body_code varchar2(255) not null
     constraint body_parts_pk
        primary key,
  body_name varchar2(255) not null
)
/

-- 9.
create table sym_has_body_part
(
  sym_code varchar2(255) not null
     constraint SHBP_SYM_CODE_fk
        references SYMPTOMS
           on delete cascade,
  body_code varchar2(255) not null
     constraint SHBP_BODY_CODE_fk
        references BODY_PARTS
           on delete cascade,
  constraint sym_has_body_part_pk
     primary key (sym_code, body_code)
)
/

-- 10.
create table medical_depts
(
  dept_code varchar2(255) not null
     constraint medical_depts_pk
        primary key,
  name varchar2(255) not null
)
/

-- 11.
create table non_medical_depts
(
  dept_code varchar2(255) not null
     constraint non_medical_depts_pk
        primary key,
  name varchar2(255) not null
)
/

-- 12.
create table services
(
  service_code varchar2(255) not null
     constraint services_pk
        primary key,
  name varchar2(255) not null
)
/

-- 13.
create table dept_has_service
(
  service_code varchar2(255) not null
     constraint DHS_SERVICE_CODE_fk
        references SERVICES
           on delete cascade,
  dept_code varchar2(255) not null
     constraint DHS_DEPT_CODE_fk
        references MEDICAL_DEPTS
           on delete cascade,
  constraint dept_has_service_pk
     primary key (service_code, dept_code)
)
/

-- 14.
create table dept_has_body_part
(
  dept_code varchar2(255) not null
     constraint DHBP_DEPT_CODE_fk
        references MEDICAL_DEPTS
           on delete cascade,
  body_code varchar2(255)
     constraint DHBP_BODY_CODE_fk
        references BODY_PARTS
           on delete cascade,
  constraint dept_has_body_part_pk
     primary key (dept_code, body_code)
)
/

-- 15.
create table facility_has_dept
(
  facility_id number not null
     constraint FHD_FACILITY_ID_fk
        references MEDICAL_FACILITIES
           on delete cascade,
  dept_code varchar2(255) not null
     constraint FHD_MEDICAL_DEPTS__fk
        references MEDICAL_DEPTS
           on delete cascade,
  constraint facility_has_dept_pk
     primary key (facility_id, dept_code)
)
/

-- 16.
create table STAFFS
(
    EMPLOYEE_ID NUMBER         not null
        constraint STAFF_PK
            primary key,
    NAME        VARCHAR2(255)  not null,
    IS_MEDICAL  CHAR default 1 not null,
    DOB         DATE,
    HIREDATE    DATE
)
/

create table FACILITY_HAS_STAFF
(
    FACILITY_ID NUMBER not null
        constraint FACILITY_ID_FK
            references MEDICAL_FACILITIES
                on delete cascade,
    EMPLOYEE_ID NUMBER not null
        constraint EMPLOYEE_ID_FK
            references STAFFS
                on delete cascade,
    constraint FACILITY_HAS_STAFF_PK
        primary key (FACILITY_ID, EMPLOYEE_ID)
)
/


-- 17.
create table non_medical_staffs
(
  employee_id number not null
     constraint non_medical_staffs_pk
        primary key,
  name varchar2(255) not null,
  designation varchar2(255) not null,
  hiredate date not null
)
/

-- 18.
create table staff_works_dept
(
  employee_id number not null
     constraint SWD_EMPLOYEE_ID_fk
        references STAFFS
           on delete cascade,
  dept_code varchar2(255) not null
     constraint SWD_DEPT_CODE_fk
        references MEDICAL_DEPTS
           on delete cascade,
  constraint staff_works_dept_pk
     primary key (employee_id, dept_code)
)
/

-- 19.
create table facility_has_staff
(
  employee_id number not null
     constraint FHS_EMPLOYEE_ID_fk
        references STAFFS
           on delete cascade,
  facility_id number not null
     constraint FHS_FACILITY_ID_fk
        references MEDICAL_FACILITIES
           on delete cascade,
  constraint facility_has_staff_pk
     primary key (employee_id, facility_id)
)
/

-- 20.
create table vitals
(
  name varchar2(255) not null,
  dob date not null,
  temperature float not null,
  blood_pressure_systolic float not null,
  blood_pressure_diastolic float not null,
  constraint vitals_pk
     primary key (name, dob, temperature, blood_pressure_systolic, blood_pressure_diastolic),
  constraint V_NAME_DOB_fk
     foreign key (name, dob) references PATIENTS
        on delete cascade
)
/

-- 21.
create table staff_records_vital
(
  employee_id number not null
     constraint SRV_EMPLOYEE_ID_fk
        references STAFFS
           on delete cascade,
  name varchar2(255) not null,
  dob date not null,
  temperature float not null,
  blood_pressure_systolic float not null,
  blood_pressure_diastolic float not null,
  constraint staff_records_vital_pk
     primary key (employee_id, name, dob, temperature, blood_pressure_systolic, blood_pressure_diastolic),
  constraint SRV_VITALS_fk
     foreign key (name, dob, temperature, blood_pressure_systolic, blood_pressure_diastolic) references VITALS
        on delete cascade
)
/

-- 22.
create table reports
(
  time date not null,
  dob date not null,
  name varchar2(255) not null,
  discharge_status varchar2(255) not null,
  treatment varchar2(255) not null,
  facility_id number not null
     constraint R_FACILITY_ID_fk
        references MEDICAL_FACILITIES
           on delete cascade,
  employee_id number not null
     constraint R_EMPLOYEE_ID_fk
        references STAFFS
           on delete cascade,
  constraint reports_pk
     primary key (time, dob, name),
  constraint R_DOB_NAME_fk
     foreign key (name, dob) references PATIENTS
        on delete cascade
)
/

-- 23.
create table staff_processes_report
(
  employee_id number not null
     constraint SPR_EMPLOYEE_ID_fk
        references STAFFS
           on delete cascade,
  time date not null,
  dob date not null,
  name varchar2(255) not null,
  constraint staff_processes_report_pk
     primary key (employee_id, time, dob, name),
  constraint SPR_REPOT_fk
     foreign key (time, dob, name) references REPORTS
        on delete cascade
)
/

-- 24.
create table negative_experiences
(
  nega_code varchar2(255) not null,
  description varchar2(255) not null,
  time date not null,
  dob date not null,
  name varchar2(255) not null,
  constraint negative_experiences_pk
     primary key (nega_code, description, time, dob, name),
  constraint NE_REPORT_fk
     foreign key (time, dob, name) references REPORTS
        on delete cascade
)
/

-- 25.
create table reasons
(
  reason_code varchar2(255) not null
     constraint R_SERVICE_CODE_fk
        references SERVICES
           on delete cascade,
  description varchar2(255) not null,
  service_code varchar2(255) not null,
  time date not null,
  dob date not null,
  name varchar2(255) not null,
  constraint reasons_pk
     primary key (reason_code, description, service_code, time, dob, name),
  constraint R_REPORT_fk
     foreign key (time, dob, name) references REPORTS
        on delete cascade
)
/

-- 26.
create table rules
(
  body_code varchar2(255) not null
     constraint R_BODY_CODE_fk
        references BODY_PARTS
           on delete cascade,
  sym_code varchar2(255) not null
     constraint R_SYM_CODE_fk
        references SYMPTOMS
           on delete cascade,
  scale_low number,
  scale_high number,
  constraint rules_pk
     primary key (body_code, sym_code)
)
/







