-- ===========================
-- ACTIVITY 1
-- ===========================
-- To see the datatype properties of the columns in the table
DESCRIBE salesman;


-- ===========================
-- ACTIVITY 2
-- ===========================
-- Inserting values into the salesman table
INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission)
VALUES
(5001, 'James Hoog', 'New York', 15),
(5002, 'Nail Knite', 'Paris', 13),
(5005, 'Pit Alex', 'London', 11),
(5006, 'McLyon', 'Paris', 14),
(5007, 'Paul Adam', 'Rome', 13),
(5003, 'Lauson Hen', 'San Jose', 12);

-- View all data from the table
SELECT * FROM salesman;


-- ===========================
-- ACTIVITY 3
-- ===========================
-- Show data from salesman_id and salesman_city columns
SELECT salesman_id, salesman_city FROM salesman;

-- Show data of salesman from Paris
SELECT * FROM salesman
WHERE salesman_city = 'Paris';

-- Show salesman_id and commission of Paul Adam
SELECT salesman_id, commission FROM salesman
WHERE salesman_name = 'Paul Adam';


-- ===========================
-- ACTIVITY 4
-- ===========================
-- Add a new column 'grade' to the salesman table
ALTER TABLE salesman
ADD grade INT;

-- Set the value in the grade column for everyone to 100
UPDATE salesman
SET grade = 100;

-- View updated table
SELECT * FROM salesman;


-- ===========================
-- ACTIVITY 5
-- ===========================
-- Update the grade score of salesmen from Rome to 200
UPDATE salesman
SET grade = 200
WHERE salesman_city = 'Rome';

-- Update the grade score of James Hoog to 300
UPDATE salesman
SET grade = 300
WHERE salesman_name = 'James Hoog';

-- Update the name McLyon to Pierre
UPDATE salesman
SET salesman_name = 'Pierre'
WHERE salesman_name = 'McLyon';

-- View final table after all updates
SELECT * FROM salesman;
