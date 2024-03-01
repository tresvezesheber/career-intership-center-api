CREATE TABLE api_users (
  id BIGINT NOT NULL AUTO_INCREMENT,
  registration VARCHAR(30) NOT NULL UNIQUE,
  name VARCHAR(150) NOT NULL,
  cpf VARCHAR(11) NOT NULL UNIQUE,
  email VARCHAR(80) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(20) NOT NULL,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,

  PRIMARY KEY (id)
);

CREATE TABLE students (
    id BIGINT NOT NULL,
    course VARCHAR(100) NOT NULL,
    admission_date DATE NOT NULL,
    graduation_date DATE,
    situation VARCHAR(30) NOT NULL,

    FOREIGN KEY (id) REFERENCES api_users(id)
);
