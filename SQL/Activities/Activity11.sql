------------------------------------------------------------
-- Activity 11 
------------------------------------------------------------

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE orders';
EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE customers';
EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE salesman';
EXCEPTION WHEN OTHERS THEN NULL; END;
/

------------------------------------------------------------
--  Create Tables
------------------------------------------------------------

CREATE TABLE salesman (
    salesman_id INT PRIMARY KEY,
    name VARCHAR2(30),
    city VARCHAR2(20),
    commission DECIMAL(5,2)
);

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR2(32),
    city VARCHAR2(20),
    grade INT,
    salesman_id INT
);

CREATE TABLE orders (
    ord_no INT PRIMARY KEY,
    purch_amt DECIMAL(10,2),
    ord_date DATE,
    customer_id INT,
    salesman_id INT
);

------------------------------------------------------------
--- Insert Data
------------------------------------------------------------

-- SALESMAN
INSERT ALL
    INTO salesman VALUES (5001, 'James Hoog', 'New York', 0.15)
    INTO salesman VALUES (5002, 'Nail Knite', 'Paris', 0.13)
    INTO salesman VALUES (5003, 'Lauson Hen', 'San Jose', 0.12)
    INTO salesman VALUES (5005, 'Pit Alex', 'London', 0.11)
    INTO salesman VALUES (5006, 'Mc Lyon', 'Paris', 0.14)
    INTO salesman VALUES (5007, 'Paul Adam', 'Rome', 0.13)
SELECT 1 FROM DUAL;

-- CUSTOMERS
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

-- ORDERS
INSERT ALL
    INTO orders VALUES (7001, 150.5,  DATE '2023-10-05', 3005, 5002)
    INTO orders VALUES (7002, 270.65, DATE '2023-09-10', 3007, 5001)
    INTO orders VALUES (7003, 65.26,  DATE '2023-10-05', 3009, 5003)
    INTO orders VALUES (7004, 110.5,  DATE '2023-08-17', 3002, 5001)
    INTO orders VALUES (7005, 948.5,  DATE '2023-09-10', 3008, 5002)
    INTO orders VALUES (7006, 2400.6, DATE '2023-07-27', 3004, 5006)
    INTO orders VALUES (7007, 5760,   DATE '2023-09-10', 3003, 5007)
    INTO orders VALUES (7008, 120.75, DATE '2023-10-05', 3002, 5001)
    INTO orders VALUES (7009, 180.25, DATE '2023-09-10', 3007, 5001)
SELECT 1 FROM DUAL;

COMMIT;

------------------------------------------------------------
--  Query 1
-- Name and ID of salesmen & customers with more than one order
------------------------------------------------------------

SELECT 
    s.name AS person_name, 
    s.salesman_id AS person_id, 
    'Salesman' AS role
FROM 
    salesman s
WHERE 
    s.salesman_id IN (
        SELECT salesman_id 
        FROM orders
        GROUP BY salesman_id
        HAVING COUNT(*) > 1
    )

UNION

SELECT 
    c.customer_name AS person_name, 
    c.customer_id AS person_id, 
    'Customer' AS role
FROM 
    customers c
WHERE 
    c.customer_id IN (
        SELECT customer_id 
        FROM orders
        GROUP BY customer_id
        HAVING COUNT(*) > 1
    )
ORDER BY 
    person_name;

------------------------------------------------------------
--  Query 2
-- Largest and smallest orders on each date, with labels
------------------------------------------------------------

-- Highest order per date
SELECT 
    o.ord_date,
    s.name AS salesman_name,
    o.purch_amt,
    'Highest on' AS status
FROM 
    orders o
JOIN 
    salesman s ON o.salesman_id = s.salesman_id
WHERE 
    o.purch_amt = (
        SELECT MAX(purch_amt)
        FROM orders x
        WHERE x.ord_date = o.ord_date
    )

UNION ALL

-- Lowest order per date
SELECT 
    o.ord_date,
    s.name AS salesman_name,
    o.purch_amt,
    'Lowest on' AS status
FROM 
    orders o
JOIN 
    salesman s ON o.salesman_id = s.salesman_id
WHERE 
    o.purch_amt = (
        SELECT MIN(purch_amt)
        FROM orders x
        WHERE x.ord_date = o.ord_date
    )
ORDER BY 
    ord_date, status DESC;
