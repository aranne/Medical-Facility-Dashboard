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

create table CERTIFICATIONS
(
    ACRONYM            VARCHAR2(255) not null
        constraint CERTIFICATIONS_PK
            primary key,
    NAME               VARCHAR2(255) not null,
    DATE_CERTIFIED     DATE not null,
    EXPIRATION_DATE    DATE not null
)
/

create table facility_has_certification
(
    facility_id number not null
        constraint FACILITY_fk
            references MEDICAL_FACILITIES
                on delete cascade,
    acronym varchar2(255) not null
        constraint CERTIFICATIONS_fk
            references CERTIFICATIONS
                on delete cascade,
    constraint facility_has_certification_pk
        primary key (FACILITY_ID, ACRONYM)
)
/

-- 2.
create table PATIENTS
(
    PATIENT_ID NUMBER,
    FIRST_NAME VARCHAR2(255),
    LAST_NAME VARCHAR2(255) not null,
    DOB DATE not null,
    PHONE VARCHAR2(255),
    ADDRESS_COUNTRY VARCHAR2(255),
    ADDRESS_STATE VARCHAR2(255),
    ADDRESS_CITY VARCHAR2(255),
    ADDRESS_STREET VARCHAR2(255),
    ADDRESS_ZIP NUMBER,
    PRIORITY_STATUS VARCHAR2(255),
    TREATMENT_TIME DATE,
    constraint PETIENTS_PK
        primary key (LAST_NAME, DOB)
)
/

create trigger PATIENT_ID_TRIGGER
    before insert
    on PATIENTS
    for each row when (NEW.PATIENT_ID is null)
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
    last_name varchar2(255) not null,
    constraint patient_has_facility_pk
        primary key (facility_id, dob, last_name),
    constraint NAME_DOB_fk
        foreign key (last_name, dob) references PATIENTS
            on delete cascade
)
/

-- 4.
create table CHECK_INS
(
    ID NUMBER not null,
    LAST_NAME VARCHAR2(255) not null,
    DOB DATE not null,
    START_TIME DATE not null,
    END_TIME DATE,
    FACILITY_ID NUMBER not null
        references MEDICAL_FACILITIES
            on delete cascade,
    PRIORITY NUMBER,
    constraint CHECK_INS_PK
        primary key (LAST_NAME, DOB, START_TIME, FACILITY_ID),
    constraint PHF_NAME_DOB_FK
        foreign key (LAST_NAME, DOB) references PATIENTS
            on delete cascade
)
/

create trigger CHECK_IN_ID_TRIGGER
    before insert
    on CHECK_INS
    for each row when (NEW.id is null)
begin
    select check_in_ID_SEQ.nextval into :new.id from dual;

end check_in_id_TRIGGER;
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
-- auto-generated definition
create table SEVERITIES
(
    ID       NUMBER        not null
        constraint SEVERITIES_PK
            primary key,
    PRIORITY NUMBER,
    SYM_CODE VARCHAR2(255) not null,
    SCALE    VARCHAR2(255) not null
)
/
create sequence sever_ID_SEQ
    nocache
/
create trigger sever_id_TRIGGER
    before insert
    on severities
    for each row
    when (NEW.id is null)
begin
    select sever_ID_SEQ.nextval into :new.id from dual;

end sever_id_TRIGGER;
/

-- 7.
create table patient_sym_meta
(
    body_code varchar2(255),
    sym_code varchar2(255),
    scale varchar2(255),
    last_name varchar2(255),
    dob date,
    duration varchar2(255),
    cause_incident varchar2(255),
    first_occurrence char(1) default 1,
    constraint PSMLAST_NAME_DOB_fk
        foreign key (last_name, dob) references PATIENTS
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
create table service_depts
(
    dept_code varchar2(255) not null
        constraint medical_depts_pk
            primary key,
    name varchar2(255) not null,
    is_Medical char(1)
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
            references SERVICE_DEPTS
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
            references SERVICE_DEPTS
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
            references SERVICE_DEPTS
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
    FIRST_NAME VARCHAR2(255)  not null,
    LAST_NAME VARCHAR2(255)  not null,
    IS_MEDICAL  CHAR default 1 not null,
    DOB         DATE,
    HIRE_DATE    DATE,
    primary_dept_code varchar2(255) not null
        constraint FHD_STAFFS_fk
            references SERVICE_DEPTS
                on delete cascade
)
/

-- 18.
create table staff_seco_works_dept
(
    employee_id number not null
        constraint SWD_SECO_EMPLOYEE_ID_fk
            references STAFFS
                on delete cascade,
    dept_code varchar2(255) not null
        constraint SWD_SECO_DEPT_CODE_fk
            references SERVICE_DEPTS
                on delete cascade,
    constraint staff_seco_works_dept_pk
        primary key (employee_id, dept_code)
)
/

create table staff_directs_dept
(
    employee_id number not null
        constraint SWD_DIR_EMPLOYEE_ID_fk
            references STAFFS
                on delete cascade,
    dept_code varchar2(255) not null
        constraint SWD_DIR_DEPT_CODE_fk
            references SERVICE_DEPTS
                on delete cascade,
    constraint staff_dir_works_dept_pk
        primary key (employee_id, dept_code)
)
/

/
-- 20.
create table VITALS
(
    ID NUMBER not null,
    LAST_NAME VARCHAR2(255) not null,
    DOB DATE not null,
    TEMPERATURE FLOAT not null,
    BLOOD_PRESSURE_SYSTOLIC FLOAT not null,
    BLOOD_PRESSURE_DIASTOLIC FLOAT not null,
    CHECKIN_TIME DATE not null,
    constraint VITALS_PK
        unique (DOB, LAST_NAME, CHECKIN_TIME),
    constraint V_NAME_DOB_FK
        foreign key (LAST_NAME, DOB) references PATIENTS
            on delete cascade
)
/

create trigger VITAL_ID_TRIGGER
    before insert
    on VITALS
    for each row when (NEW.id is null)
begin
    select vital_ID_SEQ.nextval into :new.id from dual;

end vital_id_TRIGGER;
/


-- 21.
create table STAFF_RECORDS_VITAL
(
    EMPLOYEE_ID NUMBER not null
        constraint SRV_EMPLOYEE_ID_FK
            references STAFFS
                on delete cascade,
    LAST_NAME VARCHAR2(255) not null,
    DOB DATE not null,
    TEMPERATURE FLOAT not null,
    BLOOD_PRESSURE_SYSTOLIC FLOAT not null,
    BLOOD_PRESSURE_DIASTOLIC FLOAT not null,
    CHECKIN_TIME DATE not null,
    constraint STAFF_RECORDS_VITAL_PK
        primary key (EMPLOYEE_ID, LAST_NAME, DOB, CHECKIN_TIME),
    constraint SRV_CHECKIN_TIME_FK
        foreign key (DOB, LAST_NAME, CHECKIN_TIME) references VITALS (DOB, LAST_NAME, CHECKIN_TIME)
)
/



-- 22.
create table reports
(
    id number not null,
    time date not null,
    dob date not null,
    last_name varchar2(255) not null,
    discharge_status varchar2(255),
    treatment varchar2(255),
    reason varchar2(255),
    facility_id number
        constraint R_FACILITY_ID_fk
            references MEDICAL_FACILITIES
                on delete cascade,
    employee_id number
        constraint R_EMPLOYEE_ID_fk
            references STAFFS
                on delete cascade,
    referrer_id number
        constraint R_Refer
            references STAFFS
                on delete cascade,
    refer_facility_id number
        constraint R_Refer1
            references MEDICAL_FACILITIES
                on delete cascade,
    constraint reports_pk
        primary key (time, dob, last_name),
    constraint R_DOB_NAME_fk
        foreign key (last_name, dob) references PATIENTS
            on delete cascade
)
/
create sequence report_ID_SEQ
    nocache
/
create trigger report_id_TRIGGER
    before insert
    on reports
    for each row
    when (NEW.id is null)
begin
    select report_ID_SEQ.nextval into :new.id from dual;

end report_id_TRIGGER;
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
    last_name varchar2(255) not null,
    constraint staff_processes_report_pk
        primary key (employee_id, time, dob, last_name),
    constraint SPR_REPOT_fk
        foreign key (time, dob, last_name) references REPORTS
            on delete cascade
)
/

-- 24.
create table negative_experiences
(
    id number not null,
    nega_code varchar2(255) not null,
    description varchar2(255) not null,
    time date not null,
    dob date not null,
    last_name varchar2(255) not null,
    constraint negative_experiences_pk
        primary key (nega_code, description, time, dob, last_name),
    constraint NE_REPORT_fk
        foreign key (time, dob, last_name) references REPORTS
            on delete cascade
)
/
create sequence nega_exp_ID_SEQ
    nocache
/
create trigger nega_exp_id_TRIGGER
    before insert
    on negative_experiences
    for each row
    when (NEW.id is null)
begin
    select nega_exp_ID_SEQ.nextval into :new.id from dual;

end nega_exp_id_TRIGGER;
/

-- 25.
create table reasons
(
    id number not null,
    reason_code varchar2(255) not null,
    description varchar2(255) not null,
    service_code varchar2(255) not null
        constraint R_SERVICE_CODE_fk
            references SERVICES
                on delete cascade,
    time date not null,
    dob date not null,
    last_name varchar2(255) not null,
    constraint reasons_pk
        primary key (reason_code, description, service_code, time, dob, last_name),
    constraint R_REPORT_fk
        foreign key (time, dob, last_name) references REPORTS
            on delete cascade
)
/
create sequence reason_ID_SEQ
    nocache
/
create trigger reason_id_TRIGGER
    before insert
    on reasons
    for each row
    when (NEW.id is null)
begin
    select reason_ID_SEQ.nextval into :new.id from dual;

end reason_id_TRIGGER;
/


-- 26.
create table rules
(
    id number not null,
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
create sequence rule_ID_SEQ
    nocache
/
create trigger rule_id_TRIGGER
    before insert
    on rules
    for each row
    when (NEW.id is null)
begin
    select rule_ID_SEQ.nextval into :new.id from dual;

end rule_id_TRIGGER;
/

