CREATE TABLE account
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    emp_id           BIGINT NULL,
    username         VARCHAR(255) NULL,
    password         VARCHAR(255) NULL,
    CONSTRAINT pk_account PRIMARY KEY (id)
);

CREATE TABLE address
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    street           VARCHAR(255) NULL,
    city             VARCHAR(255) NULL,
    zipcode          VARCHAR(255) NULL,
    country          VARCHAR(255) NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

CREATE TABLE candidate
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    name             VARCHAR(255) NULL,
    email            VARCHAR(255) NULL,
    phone_number     VARCHAR(255) NULL,
    current_company  VARCHAR(255) NULL,
    current_salary   BIGINT NULL,
    address_id       BIGINT NULL,
    CONSTRAINT pk_candidate PRIMARY KEY (id)
);

CREATE TABLE client
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    name             VARCHAR(255) NULL,
    address_id       BIGINT NULL,
    team_id          BIGINT NULL,
    CONSTRAINT pk_client PRIMARY KEY (id)
);

CREATE TABLE interview
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    `description`    VARCHAR(255) NULL,
    candidate_id     BIGINT NULL,
    recruiter_id     BIGINT NULL,
    job_id           BIGINT NULL,
    interview_date   datetime NULL,
    interviewer      VARCHAR(255) NULL,
    CONSTRAINT pk_interview PRIMARY KEY (id)
);

CREATE TABLE job
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    created_at        datetime NULL,
    last_modified_at  datetime NULL,
    `description`     VARCHAR(255) NULL,
    client_id         BIGINT NULL,
    bill_rate DOUBLE NULL,
    contract_duration VARCHAR(255) NULL,
    address_id        BIGINT NULL,
    CONSTRAINT pk_job PRIMARY KEY (id)
);

CREATE TABLE job_offer
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    `description`    VARCHAR(255) NULL,
    candidate_id     BIGINT NULL,
    recruiter_id     BIGINT NULL,
    job_id           BIGINT NULL,
    pay_rate DOUBLE NULL,
    start_date       datetime NULL,
    end_date         datetime NULL,
    CONSTRAINT pk_joboffer PRIMARY KEY (id)
);

CREATE TABLE manager
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    emp_id           BIGINT NULL,
    CONSTRAINT pk_manager PRIMARY KEY (id)
);

CREATE TABLE recruiter
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    name             VARCHAR(255) NULL,
    phone_number     VARCHAR(255) NULL,
    email            VARCHAR(255) NULL,
    emp_id           BIGINT NULL,
    account_id       BIGINT NULL,
    designation      SMALLINT NULL,
    team_id          BIGINT NULL,
    CONSTRAINT pk_recruiter PRIMARY KEY (id)
);

CREATE TABLE submission
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    `description`    VARCHAR(255) NULL,
    job_id           BIGINT NULL,
    recruiter_id     BIGINT NULL,
    candidate_id     BIGINT NULL,
    CONSTRAINT pk_submission PRIMARY KEY (id)
);

CREATE TABLE team
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    team_name        VARCHAR(255) NULL,
    manager_id       BIGINT NULL,
    CONSTRAINT pk_team PRIMARY KEY (id)
);

ALTER TABLE candidate
    ADD CONSTRAINT FK_CANDIDATE_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);

ALTER TABLE client
    ADD CONSTRAINT FK_CLIENT_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);

ALTER TABLE client
    ADD CONSTRAINT FK_CLIENT_ON_TEAM FOREIGN KEY (team_id) REFERENCES team (id);

ALTER TABLE interview
    ADD CONSTRAINT FK_INTERVIEW_ON_CANDIDATE FOREIGN KEY (candidate_id) REFERENCES candidate (id);

ALTER TABLE interview
    ADD CONSTRAINT FK_INTERVIEW_ON_JOB FOREIGN KEY (job_id) REFERENCES job (id);

ALTER TABLE interview
    ADD CONSTRAINT FK_INTERVIEW_ON_RECRUITER FOREIGN KEY (recruiter_id) REFERENCES recruiter (id);

ALTER TABLE job_offer
    ADD CONSTRAINT FK_JOBOFFER_ON_CANDIDATE FOREIGN KEY (candidate_id) REFERENCES candidate (id);

ALTER TABLE job_offer
    ADD CONSTRAINT FK_JOBOFFER_ON_JOB FOREIGN KEY (job_id) REFERENCES job (id);

ALTER TABLE job_offer
    ADD CONSTRAINT FK_JOBOFFER_ON_RECRUITER FOREIGN KEY (recruiter_id) REFERENCES recruiter (id);

ALTER TABLE job
    ADD CONSTRAINT FK_JOB_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);

ALTER TABLE job
    ADD CONSTRAINT FK_JOB_ON_CLIENT FOREIGN KEY (client_id) REFERENCES client (id);

ALTER TABLE recruiter
    ADD CONSTRAINT FK_RECRUITER_ON_ACCOUNT FOREIGN KEY (account_id) REFERENCES account (id);

ALTER TABLE recruiter
    ADD CONSTRAINT FK_RECRUITER_ON_TEAM FOREIGN KEY (team_id) REFERENCES team (id);

ALTER TABLE submission
    ADD CONSTRAINT FK_SUBMISSION_ON_CANDIDATE FOREIGN KEY (candidate_id) REFERENCES candidate (id);

ALTER TABLE submission
    ADD CONSTRAINT FK_SUBMISSION_ON_JOB FOREIGN KEY (job_id) REFERENCES job (id);

ALTER TABLE submission
    ADD CONSTRAINT FK_SUBMISSION_ON_RECRUITER FOREIGN KEY (recruiter_id) REFERENCES recruiter (id);

ALTER TABLE team
    ADD CONSTRAINT FK_TEAM_ON_MANAGER FOREIGN KEY (manager_id) REFERENCES manager (id);