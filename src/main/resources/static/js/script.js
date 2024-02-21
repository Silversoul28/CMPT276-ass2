// var n=window.prompt("Name?", "Brooklyn")
// // window.alert("Hello "+ n)
// console.log("Hello " + n)


// for(var i=0;i<10;i++){
//     console.log(i)
// }

// var person={
// name:'Brooklyn',
// age: 21,
// address:{
//     number: '123',
//     street: 'fake st'

// },
// speak: function(words){

//     console.log(words)
// }
// }

// for(let i=0; i<10; i++){//let instead of var keeps i in scope

//     console.log(i)
// }

// var a=[2, 3, 9, 6, 3, 12, 1, 3, 19]
// myfunc()
// function myfunc(){

// console.log(a)

// }


// var myfunc2=function(){
//     console.log('Hello Word')
// }
// myfunc2()

// //callbacks

// function ascending(a, b){

// return a-b;

// }
// var i=0
// var inter = window.setInterval(function(){
//     console.log(i)
//     i++
// }, 1000)//call it every second

// window.clearInterval(inter)

// person.speak('hello')


//  var t = document.getElementById("fname")

//  t.value="Brook"

// console.log(t.name)

// var c = document.querySelector('input[value="FULLSEND"]')

// var td = document.getElementsByTagName("td")

// console.log(td[0])

 //callback
function processKey(evt){
    console.log(evt.key)
   }

 window.addEventListener("keypress", processKey)




var button = document.querySelector('input[value="FULLSEND"]')//grab the submit button
button.addEventListener('click', function(evt){
    evt.preventDefault()
    var text = document.getElementById('fname').value
    console.log(document.getElementsByTagName("legend")[0].innerHTML)
    document.getElementsByTagName('legend')[0].innerHTML = text
})

