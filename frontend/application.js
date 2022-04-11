class Task{
  name;
  description;
  priority; // 1 - 5; //listagem
  dateEnd; // tipo data
  category;
  status; //to do, doing, done; //listagem 

  constructor(name, description, priority, dateEnd, category, status) {
      this.name = name;
      this.description = description;
      this.priority = priority;
      this.dateEnd = dateEnd;
      this.category = category;
      this.status = status;
  }
}

const botaoAdd = document.querySelector("#addBtn");
const botaoRemove = document.querySelector("#clear-list");
const nameTask = document.querySelector("#nameTask");
const descriptionTask = document.querySelector("#descriptionTask");
const priorityTask = document.querySelector("#priorityTask");
const dateEndTask = document.querySelector("#dateEndTask");
const categoryTask = document.querySelector("#categoryTask");
const statusTask = document.querySelector("#sttTask");
const listTaskHtml = document.querySelector(".listTask");
const listTasks = [];

console.log(botaoAdd)
botaoAdd.addEventListener('click', () => addTask());
botaoRemove.addEventListener('click', () => removeAllTasks());

alert(" Hiding a Task doesn´t remove it from your list, only just hide from your painel!");

function verificaData(dataLida){
  let today = new Date();
  let nums = dataLida.split("-");
  console.log(dataLida);
  console.log(nums);
  let dateEnding = new Date(Number(nums[0]),Number(nums[1])-1,Number(nums[2]))
  console.log(dateEnding - today);
  if(dateEnding - today < 0){
      return false; 
  } else {
    return true;
  }
}

function buildTask(){
    if(!verificaData(dateEndTask.value)){
      alert("Insira uma data válida!")
      return false;
    }
    let newTask = new Task(nameTask.value, descriptionTask.value,Number(priorityTask.value),dateEndTask.value,categoryTask.value, statusTask.value);
    let x = new Date();
    return newTask;
}

function addTask(){
  const task = buildTask();
  if(task){
    listTasks.push(task);
    //showTasks();
    let saida ="";
    listTasks.forEach((t) =>{
      saida +=`<div class="task"><p >${t.name}</p><p>${t.description}</p><p >${t.priority}</p><p >${t.dateEnd}</p><p >${t.category}</p><p >${t.status}</p> </div>`;
    });
    listTaskHtml.innerHTML = saida;
    bttDeleteTask();
    bttCloseTask();
  } else {
    return;
  }
}

//Add a button to delete Task:
function bttDeleteTask(){
  let myNodelist = document.getElementsByClassName("task");
  let i;
  for (i = 0; i < myNodelist.length; i++) {
  let span = document.createElement("SPAN");
  let txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  myNodelist[i].appendChild(span);
  }
}

//Click on a close button to hide the current list item and
function bttCloseTask(){
  var close = document.getElementsByClassName("close");
  var i;
  for (i = 0; i < close.length; i++) {
  close[i].onclick = function() {
  var div = this.parentElement;
  div.style.display = "none";
    }
  }
}


//Clearing the list
function removeAllTasks(){
  var lst = document.getElementsByClassName("listTask");
  console.log(lst);
    lst[0].innerHTML = "";
    while(listTasks.length > 0){
      listTasks.pop();
    }
}

