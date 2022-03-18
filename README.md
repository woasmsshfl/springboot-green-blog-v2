## 블로그 V2 코드 연습

### DB, User Create
```sql
-- 모든 IP로 접근 가능한 유저 생성
CREATE USER 'green'@'%' IDENTIFIED BY 'green1234';

-- DB 생성
CREATE DATABASE greendb;

-- 모든 권한을 줌
GRANT ALL PRIVILEGES ON greendb.* TO 'green'@'%';
```

### 2. Project Setting
- application.yml
- view create
