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
    PATIENT_ID      NUMBER,
    FIRST_NAME       VARCHAR2(255),
    LAST_NAME        VARCHAR2(255) not null,
    DOB             DATE          not null,
    PHONE           VARCHAR2(255),
    ADDRESS_COUNTRY VARCHAR2(255),
    ADDRESS_STATE   VARCHAR2(255),
    ADDRESS_CITY    VARCHAR2(255),
    ADDRESS_STREET  VARCHAR2(255),
    ADDRESS_ZIP     NUMBER,
    PRIORITY_STATUS VARCHAR2(255),
    TREATMENT_TIME  DATE,
    constraint PETIENTS_PK
        primary key (LAST_NAME, DOB)
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
    last_name varchar2(255) not null,
    constraint patient_has_facility_pk
        primary key (facility_id, dob, last_name),
    constraint NAME_DOB_fk
        foreign key (last_name, dob) references PATIENTS
            on delete cascade
)
/

-- 4.
create table check_ins
(
    id number not null,
    last_name varchar2(255) not null,
    dob date not null,
    start_time date not null,
    end_time date,
    facility_id number not null,
        foreign key (facility_id) references MEDICAL_FACILITIES
            on delete cascade,
                   constraint check_ins_pk
                   primary key (last_name, dob, start_time, facility_id),
                   constraint PHF_NAME_DOB_fk
                   foreign key (last_name, dob) references PATIENTS
                       on delete cascade
                      )
/
create sequence check_in_ID_SEQ
    nocache
/
create trigger check_in_id_TRIGGER
    before insert
    on check_ins
    for each row
    when (NEW.id is null)
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
create table vitals
(
    id number not null,
    last_name varchar2(255) not null,
    dob date not null,
    temperature float not null,
    blood_pressure_systolic float not null,
    blood_pressure_diastolic float not null,
    constraint vitals_pk
        primary key (last_name, dob, temperature, blood_pressure_systolic, blood_pressure_diastolic),
    constraint V_NAME_DOB_fk
        foreign key (last_name, dob) references PATIENTS
            on delete cascade
)
/
create sequence vital_ID_SEQ
    nocache
/
create trigger vital_id_TRIGGER
    before insert
    on vitals
    for each row
    when (NEW.id is null)
begin
    select vital_ID_SEQ.nextval into :new.id from dual;

end vital_id_TRIGGER;
/


-- 21.
create table staff_records_vital
(
    employee_id number not null
        constraint SRV_EMPLOYEE_ID_fk
            references STAFFS
                on delete cascade,
    last_name varchar2(255) not null,
    dob date not null,
    temperature float not null,
    blood_pressure_systolic float not null,
    blood_pressure_diastolic float not null,
    constraint staff_records_vital_pk
        primary key (employee_id, last_name, dob, temperature, blood_pressure_systolic, blood_pressure_diastolic),
    constraint SRV_VITALS_fk
        foreign key (last_name, dob, temperature, blood_pressure_systolic, blood_pressure_diastolic) references VITALS
            on delete cascade
)
/

-- 22.
create table reports
(
    id number not null,
    time date not null,
    dob date not null,
    last_name varchar2(255) not null,
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
    reason_code varchar2(255) not null
        constraint R_SERVICE_CODE_fk
            references SERVICES
                on delete cascade,
    description varchar2(255) not null,
    service_code varchar2(255) not null,
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

