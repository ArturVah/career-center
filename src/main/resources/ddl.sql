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