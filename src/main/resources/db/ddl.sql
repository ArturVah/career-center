CREATE TABLE job_announcement
(
  id                     INT AUTO_INCREMENT PRIMARY KEY,
  enabled                BIT          NULL,
  jobDescription         VARCHAR(255) NULL,
  jobResponsibilities    VARCHAR(255) NULL,
  location               VARCHAR(255) NULL,
  requiredQualifications VARCHAR(255) NULL,
  startDate              VARCHAR(255) NULL,
  term                   VARCHAR(255) NULL,
  title                  VARCHAR(255) NULL
);

CREATE TABLE users (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  email     VARCHAR(255) NOT NULL UNIQUE,
  password  VARCHAR(255) NOT NULL,
  role      VARCHAR(255),
  is_active BOOLEAN
);