function show() {
    fetch("http://localhost:8080/courses")
    .then(response => response.json())
    .then(courses => {
        const datatable = document.getElementById("coursetable");
        let rows = "";
        courses.forEach(course => {
            rows += `<tr>
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>${course.trainer}</td>
                <td>${course.durationInWeeks}</td>
            </tr>`;
        });
        datatable.innerHTML = rows; 
    })
    .catch(error => {
        console.error("Error fetching courses:", error);
    });
}

function showeS() {
    fetch("http://localhost:8080/courses/enrolled")
    .then(response => response.json())
    .then(courses => {
        const datatable = document.getElementById("enrolled");
        let rows = "";
        courses.forEach(course => {
            rows += `<tr>
                <td>${course.name}</td>
                <td>${course.emailId}</td>
                <td>${course.courName}</td>
                
            </tr>`;
        });
        datatable.innerHTML = rows; 
    })
    .catch(error => {
        console.error("Error fetching courses:", error);
    });
}

