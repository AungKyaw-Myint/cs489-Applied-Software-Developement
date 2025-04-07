SELECT * FROM Dentist
ORDER BY last_name ASC;

SELECT A.*, P.first_name, P.last_name, P.phone
FROM Appointment A
JOIN Patient P ON A.patient_id = P.patient_id
WHERE A.dentist_id = 1;


SELECT A.*, S.name AS surgery_name
FROM Appointment A
JOIN Surgery S ON A.surgery_id = S.surgery_id;

SELECT * FROM Appointment
WHERE patient_id = 1 AND date = '2025-04-10';

