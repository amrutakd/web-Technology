document.getElementById('registrationForm').addEventListener('submit', function (event) {
    let isValid = true;

    const username = document.getElementById('username').value.trim();
    const password = document.getElementById('password').value.trim();
    const age = document.getElementById('age').value.trim();
    const address = document.getElementById('Address').value.trim();
    const dob = document.getElementById('DOB').value.trim();
    const gender = document.querySelector('input[name="gender"]:checked');
    const qualification = document.getElementById('Qualification').value.trim();
    const file = document.getElementById('file').value.trim();
    const courses = document.querySelectorAll('input[name="Course"]:checked');

    // Check username
    if (!username) {
        alert("Username is required.");
        isValid = false;
    }

    // Check password
    if (!password) {
        alert("Password is required.");
        isValid = false;
    }

    // Check age
    if (!age) {
        alert("Age is required.");
        isValid = false;
    }

    // Check address
    if (!address) {
        alert("Address is required.");
        isValid = false;
    }

    // Check DOB
    if (!dob) {
        alert("Date of Birth is required.");
        isValid = false;
    }

    // Check gender
    if (!gender) {
        alert("Please select a gender.");
        isValid = false;
    }

    // Check qualification
    if (!qualification) {
        alert("Qualification is required.");
        isValid = false;
    }

    // Check file upload
    if (!file) {
        alert("Please upload a file.");
        isValid = false;
    }

    // Check at least one course is selected
    if (courses.length === 0) {
        alert("Please select at least one course.");
        isValid = false;
    }

    // Prevent form submission if any field is invalid
    if (!isValid) {
        event.preventDefault();
    }
});
