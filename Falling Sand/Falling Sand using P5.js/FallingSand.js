
function make2DArray(cols, rows){
  let arr = new Array(cols);
  for(let i =0; i< arr.length; i++){
    arr[i] = new Array(rows);
    for(let j =0; j< arr[i].length; j++){
      arr[i][j] = 0;
    }
  }
  return arr;
}

let grid;
let w = 10;
let cols, rows;

function setup() {
  createCanvas(400, 400);
  cols =  width / w;
  rows = height / w;
  grid = make2DArray(cols, rows);
  
  
  for (let i =0; i< cols; i++){
    for(let j = 0; j<rows; j++){
      grid[i][j] = 0;
    }
  }
  grid[20][10] = 1;
} 

function mouseDragged(){
  let col = floor(mouseX / w);
  let row = floor(mouseY / w);
  grid[col][row] = 1;
}

function draw() {
  background(0);
  
  for (let i =0; i< cols; i++){
    for(let j = 0; j<rows; j++){
      stroke(255);
      fill(grid[i][j]*255);
      let x = i*w;
      let y = j*w;
      square(x,y,w);
    }
  }
  
  let nextGrid = make2DArray(cols, rows);
  for (let i =0; i< cols; i++){
    for(let j = 0; j<rows; j++){
    let state = grid[i][j];
      if(state == 1){
        let below = grid[i][j+1];
        let belowR = grid[i+1][j +1];
        let belowL = grid[i-1][j +1];
       if(below == 0 ){
          nextGrid[i][j] = 0;
          nextGrid[i][j+1] = 1;
        }else if(belowR == 0){
          nextGrid[i+1][j] = 1;
        }else if(belowL == 0){
          nextGrid[i-1][j] = 1;
        }else{
          nextGrid[i][j] = 1;
        }
      }
      
    }
  }
  grid = nextGrid;
  

}