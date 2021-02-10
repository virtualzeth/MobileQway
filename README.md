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
    user_id INTEGER not null
        constraint addresses_pk
            primary key,
    street      TEXT    not null,
    city        TEXT    not null,
    postal_code TEXT    not null
);

create table transactions (
    id INTEGER not null
        constraint transactions_pk
            primary key autoincrement,
    first_user_id  INTEGER not null,
    second_user_id INTEGER not null,
    amount         REAL    not null
);

create table users (
    id INTEGER not null
        constraint users_pk
            primary key autoincrement,
    name              TEXT    not null,
    phone_number      TEXT    not null,
    card_number       TEXT    not null,
    registration_date TEXT    not null,
    CVR_number        TEXT
);
```

## Contributions
qwe

## License
qwe