# Mobile Qway

---

## Description
qwe

## Installation
qwe

## Usage
qwe

### Query Examples
Create tables:
```sqlite
create table addresses (
                           phone_number TEXT not null
                               constraint addresses_pk
                                   primary key,
                           street      TEXT    not null,
                           city        TEXT    not null,
                           postal_code TEXT    not null
);

create table transactions (
                              phone_number TEXT not null
                                  constraint transactions_pk
                                      primary key,
                              first_user_id  INTEGER not null,
                              second_user_id INTEGER not null,
                              amount         REAL    not null
);

create table users (
                       phone_number TEXT not null
                           constraint table_name_pk
                               primary key,
                       name              TEXT    not null,
                       registration_date TEXT    not null
);

create table credentials (
                             phone_number TEXT not null
                                 constraint table_name_pk
                                     primary key,
                             salt              TEXT    not null,
                             hash              TEXT    not null
);

create table cards (
                       phone_number TEXT not null
                           constraint table_name_pk
                               primary key,
                       card_number    TEXT       not null,
                       active         BOOLEAN    not null
);
```

## Contributions
qwe

## Ressources
[Password regex](https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a)

## License
qwe