function loadPersons(){
    console.log("Loading persons...");
    fetch("https://sbapp-nrfs.onrender.com/person")
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error("Error:", error);
    });
}