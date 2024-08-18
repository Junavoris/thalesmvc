document.addEventListener('DOMContentLoaded', function() {
    const searchButton = document.getElementById('searchButton');
    const employeeIdInput = document.getElementById('employeeIdInput');

    searchButton.addEventListener('click', function() {
        const employeeId = employeeIdInput.value.trim();

        if (employeeId === "") {
            fetchAllEmployees();
        } else {
            fetchEmployeeById(employeeId);
        }
    });
});

function fetchAllEmployees() {
    fetch('/employees')
        .then(response => response.json())
        .then(data => {
            displayEmployees(data);
        })
        .catch(error => console.error('Error fetching employee data:', error));
}

function fetchEmployeeById(employeeId) {
    fetch(`/employee/${employeeId}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Employee not found');
            }
        })
        .then(data => {
            displayEmployees([data]);  // Convert single employee data to an array
        })
        .catch(error => console.error('Error fetching employee data:', error));
}

function displayEmployees(data) {
    const employeeTable = document.getElementById('employeeTable');

    let tableHtml = '<h5 class="card-title">Search Result</h5><table class="table table-striped table-hover">';
    tableHtml += '<thead><tr><th>ID</th><th>Name</th><th>Salary</th><th>Age</th><th>Profile Image</th><th>Annual Salary</th></tr></thead>';
    tableHtml += '<tbody>';

    data.forEach(employee => {
        tableHtml += `<tr>
                        <td>${employee.id}</td>
                        <td>${employee.employee_name}</td>
                        <td>${employee.employee_salary}</td>
                        <td>${employee.employee_age}</td>
                        <td>${employee.profile_image}</td>
                        <td>${employee.annualSalary}</td>
                      </tr>`;
    });

    tableHtml += '</tbody></table>';

    employeeTable.innerHTML = tableHtml;
}
