document.querySelector('#submit').addEventListener('click', event =>{
let sendForm = document.querySelector('#booking');
let bookingObject = {
    id: 0,
    date: sendForm[0].value,
    guest:{
        firstName: sendForm[3].value,
        lastName: sendForm[4].value,
        address: null,
        emailAddress: sendForm[7].value
    },
    amountOfPersons:sendForm[1].value,
    extras:[{
        name: sendForm[8].value,
        price: 0.0
    }],
    orders:[{
        id: 0,
        menuItems: null,
        status: null
    }]

};
console.log(bookingObject);

fetch("http://localhost:8080/api/booking/post", {
        method: "POST",
        headers: {
            "Content-Type": "application/json; charset=utf-8",
        },
        body: JSON.stringify(bookingObject),
        success: () => {
            console.log("succes");
        }
    });

});
   

// document.querySelector('#isPossible').addEventListener('click', event=>{
//     document.querySelector('#naw').style.visibility = "visible";
//     //moet anders met this ofzo maar kan niet vinden
//     // document.querySelector('#isPossible').style.visibility = "hidden";
// });
    
