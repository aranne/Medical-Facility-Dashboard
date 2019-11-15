create sequence patient_ID_SEQ
    nocache
/


create sequence check_in_ID_SEQ
    nocache
/


create sequence sever_ID_SEQ
    nocache
/


create sequence vital_ID_SEQ
    nocache
/


create sequence report_ID_SEQ
    nocache
/


create sequence nega_exp_ID_SEQ
    nocache
/

create sequence reason_ID_SEQ
    nocache
/

create sequence rule_ID_SEQ
    nocache
/


create table MEDICAL_FACILITIES
(
    FACILITY_ID NUMBER not null
        constraint MEDICAL_FACILITIES_PK
            primary key,
    NAME VARCHAR2(255) not null,
    CLASSIFICATION VARCHAR2(255) not null,
    ADDRESS VARCHAR2(255) not null,
    CAPACITY VARCHAR2(255) not null
)
/

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

create table PATIENT_HAS_FACILITY
(
    FACILITY_ID NUMBER not null
        constraint FACILITY_ID_FK
            references MEDICAL_FACILITIES
                on delete cascade,
    DOB DATE not null,
    LAST_NAME VARCHAR2(255) not null,
    constraint PATIENT_HAS_FACILITY_PK
        primary key (FACILITY_ID, DOB, LAST_NAME),
    constraint NAME_DOB_FK
        foreign key (LAST_NAME, DOB) references PATIENTS
            on delete cascade
)
/

create table SYMPTOMS
(
    NAME VARCHAR2(255) not null,
    SYM_CODE VARCHAR2(255) not null
        constraint SYMPTOMS_PK
            primary key
)
/

create table SEVERITIES
(
    ID NUMBER not null,
    VALUE NUMBER not null,
    NAME VARCHAR2(255) not null,
    SCALE VARCHAR2(255) not null,
    BLEEDING VARCHAR2(255),
    constraint SEVERITIES_PK
        primary key (VALUE, NAME, SCALE)
)
/

create trigger SEVER_ID_TRIGGER
    before insert
    on SEVERITIES
    for each row when (NEW.id is null)
begin
    select sever_ID_SEQ.nextval into :new.id from dual;

end sever_id_TRIGGER;
/

create table PATIENT_HAS_SYM_SERVERITY
(
    SYM_CODE VARCHAR2(255) not null
        constraint PHSE_SYM_CODE_FK
            references SYMPTOMS
                on delete cascade,
    VALUE NUMBER not null,
    SNAME VARCHAR2(255) not null,
    SCALE VARCHAR2(255) not null,
    LAST_NAME VARCHAR2(255) not null,
    DOB DATE not null,
    DURATION FLOAT not null,
    CAUSE_INCIDENT VARCHAR2(255) not null,
    FIRST_OCCURRENCE CHAR default 0 not null,
    constraint PATIENT_HAS_SYM_SEVERITY_PK
        primary key (SYM_CODE, VALUE, SNAME, SCALE, LAST_NAME, DOB),
    constraint PHSE_PATIENT_FK
        foreign key (LAST_NAME, DOB) references PATIENTS
            on delete cascade,
    constraint PHSE_SEVERITY_FK
        foreign key (VALUE, SNAME, SCALE) references SEVERITIES
            on delete cascade
)
/

create table BODY_PARTS
(
    BODY_CODE VARCHAR2(255) not null
        constraint BODY_PARTS_PK
            primary key,
    BODY_NAME VARCHAR2(255) not null
)
/

create table SYM_HAS_BODY_PART
(
    SYM_CODE VARCHAR2(255) not null
        constraint SHBP_SYM_CODE_FK
            references SYMPTOMS
                on delete cascade,
    BODY_CODE VARCHAR2(255) not null
        constraint SHBP_BODY_CODE_FK
            references BODY_PARTS
                on delete cascade,
    constraint SYM_HAS_BODY_PART_PK
        primary key (SYM_CODE, BODY_CODE)
)
/

create table SERVICE_DEPTS
(
    DEPT_CODE VARCHAR2(255) not null
        constraint MEDICAL_DEPTS_PK
            primary key,
    NAME VARCHAR2(255) not null,
    IS_MEDICAL CHAR
)
/

create table SERVICES
(
    SERVICE_CODE VARCHAR2(255) not null
        constraint SERVICES_PK
            primary key,
    NAME VARCHAR2(255) not null
)
/

create table DEPT_HAS_SERVICE
(
    SERVICE_CODE VARCHAR2(255) not null
        constraint DHS_SERVICE_CODE_FK
            references SERVICES
                on delete cascade,
    DEPT_CODE VARCHAR2(255) not null
        constraint DHS_DEPT_CODE_FK
            references SERVICE_DEPTS
                on delete cascade,
    constraint DEPT_HAS_SERVICE_PK
        primary key (SERVICE_CODE, DEPT_CODE)
)
/

create table DEPT_HAS_BODY_PART
(
    DEPT_CODE VARCHAR2(255) not null
        constraint DHBP_DEPT_CODE_FK
            references SERVICE_DEPTS
                on delete cascade,
    BODY_CODE VARCHAR2(255) not null
        constraint DHBP_BODY_CODE_FK
            references BODY_PARTS
                on delete cascade,
    constraint DEPT_HAS_BODY_PART_PK
        primary key (DEPT_CODE, BODY_CODE)
)
/

create table FACILITY_HAS_DEPT
(
    FACILITY_ID NUMBER not null
        constraint FHD_FACILITY_ID_FK
            references MEDICAL_FACILITIES
                on delete cascade,
    DEPT_CODE VARCHAR2(255) not null
        constraint FHD_MEDICAL_DEPTS__FK
            references SERVICE_DEPTS
                on delete cascade,
    constraint FACILITY_HAS_DEPT_PK
        primary key (FACILITY_ID, DEPT_CODE)
)
/

create table STAFFS
(
    EMPLOYEE_ID NUMBER not null
        constraint STAFF_PK
            primary key,
    FIRST_NAME VARCHAR2(255) not null,
    LAST_NAME VARCHAR2(255) not null,
    IS_MEDICAL CHAR default 1 not null,
    DOB DATE,
    HIRE_DATE DATE,
    PRIMARY_DEPT_CODE VARCHAR2(255) not null
        constraint FHD_STAFFS_FK
            references SERVICE_DEPTS
                on delete cascade
)
/

create table STAFF_SECO_WORKS_DEPT
(
    EMPLOYEE_ID NUMBER not null
        constraint SWD_SECO_EMPLOYEE_ID_FK
            references STAFFS
                on delete cascade,
    DEPT_CODE VARCHAR2(255) not null
        constraint SWD_SECO_DEPT_CODE_FK
            references SERVICE_DEPTS
                on delete cascade,
    constraint STAFF_SECO_WORKS_DEPT_PK
        primary key (EMPLOYEE_ID, DEPT_CODE)
)
/

create table STAFF_DIRECTS_DEPT
(
    EMPLOYEE_ID NUMBER not null
        constraint SWD_DIR_EMPLOYEE_ID_FK
            references STAFFS
                on delete cascade,
    DEPT_CODE VARCHAR2(255) not null
        constraint SWD_DIR_DEPT_CODE_FK
            references SERVICE_DEPTS
                on delete cascade,
    constraint STAFF_DIR_WORKS_DEPT_PK
        primary key (EMPLOYEE_ID, DEPT_CODE)
)
/

create table VITALS
(
    ID NUMBER not null,
    LAST_NAME VARCHAR2(255) not null,
    DOB DATE not null,
    TEMPERATURE FLOAT not null,
    BLOOD_PRESSURE_SYSTOLIC FLOAT not null,
    BLOOD_PRESSURE_DIASTOLIC FLOAT not null,
    constraint VITALS_PK
        primary key (LAST_NAME, DOB, TEMPERATURE, BLOOD_PRESSURE_SYSTOLIC, BLOOD_PRESSURE_DIASTOLIC),
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
    constraint STAFF_RECORDS_VITAL_PK
        primary key (EMPLOYEE_ID, LAST_NAME, DOB, TEMPERATURE, BLOOD_PRESSURE_SYSTOLIC, BLOOD_PRESSURE_DIASTOLIC),
    constraint SRV_VITALS_FK
        foreign key (LAST_NAME, DOB, TEMPERATURE, BLOOD_PRESSURE_SYSTOLIC, BLOOD_PRESSURE_DIASTOLIC) references VITALS
            on delete cascade
)
/

create table REPORTS
(
    ID NUMBER not null,
    TIME DATE not null,
    DOB DATE not null,
    LAST_NAME VARCHAR2(255) not null,
    DISCHARGE_STATUS VARCHAR2(255) not null,
    TREATMENT VARCHAR2(255) not null,
    FACILITY_ID NUMBER not null
        constraint R_FACILITY_ID_FK
            references MEDICAL_FACILITIES
                on delete cascade,
    EMPLOYEE_ID NUMBER not null
        constraint R_EMPLOYEE_ID_FK
            references STAFFS
                on delete cascade,
    constraint REPORTS_PK
        primary key (TIME, DOB, LAST_NAME),
    constraint R_DOB_NAME_FK
        foreign key (LAST_NAME, DOB) references PATIENTS
            on delete cascade
)
/

create trigger REPORT_ID_TRIGGER
    before insert
    on REPORTS
    for each row when (NEW.id is null)
begin
    select report_ID_SEQ.nextval into :new.id from dual;

end report_id_TRIGGER;
/

create table STAFF_PROCESSES_REPORT
(
    EMPLOYEE_ID NUMBER not null
        constraint SPR_EMPLOYEE_ID_FK
            references STAFFS
                on delete cascade,
    TIME DATE not null,
    DOB DATE not null,
    LAST_NAME VARCHAR2(255) not null,
    constraint STAFF_PROCESSES_REPORT_PK
        primary key (EMPLOYEE_ID, TIME, DOB, LAST_NAME),
    constraint SPR_REPOT_FK
        foreign key (TIME, DOB, LAST_NAME) references REPORTS
            on delete cascade
)
/

create table NEGATIVE_EXPERIENCES
(
    ID NUMBER not null,
    NEGA_CODE VARCHAR2(255) not null,
    DESCRIPTION VARCHAR2(255) not null,
    TIME DATE not null,
    DOB DATE not null,
    LAST_NAME VARCHAR2(255) not null,
    constraint NEGATIVE_EXPERIENCES_PK
        primary key (NEGA_CODE, DESCRIPTION, TIME, DOB, LAST_NAME),
    constraint NE_REPORT_FK
        foreign key (TIME, DOB, LAST_NAME) references REPORTS
            on delete cascade
)
/

create trigger NEGA_EXP_ID_TRIGGER
    before insert
    on NEGATIVE_EXPERIENCES
    for each row when (NEW.id is null)
begin
    select nega_exp_ID_SEQ.nextval into :new.id from dual;

end nega_exp_id_TRIGGER;
/

create table REASONS
(
    ID NUMBER not null,
    REASON_CODE VARCHAR2(255) not null
        constraint R_SERVICE_CODE_FK
            references SERVICES
                on delete cascade,
    DESCRIPTION VARCHAR2(255) not null,
    SERVICE_CODE VARCHAR2(255) not null,
    TIME DATE not null,
    DOB DATE not null,
    LAST_NAME VARCHAR2(255) not null,
    constraint REASONS_PK
        primary key (REASON_CODE, DESCRIPTION, SERVICE_CODE, TIME, DOB, LAST_NAME),
    constraint R_REPORT_FK
        foreign key (TIME, DOB, LAST_NAME) references REPORTS
            on delete cascade
)
/

create trigger REASON_ID_TRIGGER
    before insert
    on REASONS
    for each row when (NEW.id is null)
begin
    select reason_ID_SEQ.nextval into :new.id from dual;

end reason_id_TRIGGER;
/

create table RULES
(
    ID NUMBER not null,
    BODY_CODE VARCHAR2(255) not null
        constraint R_BODY_CODE_FK
            references BODY_PARTS
                on delete cascade,
    SYM_CODE VARCHAR2(255) not null
        constraint R_SYM_CODE_FK
            references SYMPTOMS
                on delete cascade,
    SCALE_LOW NUMBER,
    SCALE_HIGH NUMBER,
    constraint RULES_PK
        primary key (BODY_CODE, SYM_CODE)
)
/

create trigger RULE_ID_TRIGGER
    before insert
    on RULES
    for each row when (NEW.id is null)
begin
    select rule_ID_SEQ.nextval into :new.id from dual;

end rule_id_TRIGGER;
/





