const addMenuInput = document.querySelector('#menuInput').innerHTML;
function addIngredient(){
    let selectedValue = document.querySelector('#ingredientList').value;
    document.querySelector('#selectedIngredients').innerHTML += `<div class="ingredient">${selectedValue}</div>`;
}
function clearInput(){
    let toClear = document.querySelectorAll('.clearInput');
    for(i = 0; i < toClear.length; i++){
        toClear[i].value = "";
    }
    document.querySelector('#selectedIngredients').innerHTML = "";
}
function addAnother(){
    let currentMenuInput = document.querySelector('#menuInput');
    currentMenuInput.innerHTML += addMenuInput;
}