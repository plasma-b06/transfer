#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
 
#define OK 0
#define MOVE_MADE 1
#define OUT_OF_RANGE 2
#define WINNER 3
#define EXIT 666
 
char player[] = {'O', 'X'};
char grid[3][3][2];
int computer = 0;
 
int wins[] = {0, 0, 0, 0, 0, 0, 0, 0}; /* There are only 8 possible wins.
                      Three horizontal, three vertical,
                      and two diagonal. These are shown
                      by marking the fields in this array */
 
void format_grid(){
  int x, y;
  char ch = '\0';
 
  for(x = 0, y = 0; x < 3; x++){
    while(y < 3){
      grid[x][y][0] = ' ';
      grid[x][y][1] = ch;
      y++;
    }
    y = 0;
  }
}
 
void print_grid(){
  int x, y;
 
  printf("\t\t .0.1.2.Y\n");
  for(x = 0, y = 0; x < 3; x++){
    while(y < 3){
      if(y == 0)
    printf("\t\t%i", x);
      printf("|%s", grid[x][y]);
      y++;
    }
    printf("|\n");
    y = 0;
  }
  printf("\t\tX\n");
}
 
int is_winner(char ch){
  int x, y;
  int count;
 
  /* Horizontal check */
  for(x = 0, y = 0, count = 0; x < 3; x++){
    while(y < 3){
      if(grid[x][y][0] == ch){
    count++;
      }
      y++;
    }
      if(count == 3)
    return WINNER;
      else
    count = 0;
    y = 0;
  }
 
  /* Vertical check */
  for(x = 0, y = 0, count = 0; y < 3; y++){
    while(x < 3){
      if(grid[x][y][0] == ch){
    count++;
      }
      x++;
    }
      if(count == 3)
    return WINNER;
      else
    count = 0;
    x = 0;
  }
 
  /* Diagonal checks */
  if(grid[0][0][0] == ch && grid[1][1][0] == ch && grid[2][2][0] == ch)
    return WINNER;
  if(grid[2][0][0] == ch && grid[1][1][0] == ch && grid[0][2][0] == ch)
    return WINNER;
 
  return OK;
}
 
int maxarrey(){
  int i, ti, tn, n;
  for(i = 0, ti = tn = 0; i < 8; i++){
    if(wins[i] > tn){
      tn = wins[i];
      ti = i;
    }
    if(wins[i] == tn && wins[i] > 0){
      for(n = 0; n < 3; n++){
    if(i >= 0 && i <= 2){
      if(grid[i][n][0] == ' '){
        ti = i;
        tn = wins[i];
      }
    }
    if(i >= 3 && i <= 5){
      if(grid[n][i][0] == ' '){
        ti = i;
        tn = wins[i];
      }
    }
    if(i == 6 && (grid[0][0][0] == ' ' || grid[1][1][0] == ' ' || grid[2][2][0] == ' ')){
      ti = i;
      tn = wins[i];
    }
    if(i == 7 && (grid[0][2][0] == ' ' || grid[1][1][0] == ' ' || grid[2][0][0] == ' ')){
      ti = i;
      tn = wins[i];
    }
      }
    }
  }
  return ti;
}
 
int minarrey(){
  int i, ti, tn, n;
  for(i = 0, ti = tn = 0; i < 8; i++){
    if(wins[i] < tn){
      tn = wins[i];
      ti = i;
    }
    if(wins[i] == tn && wins[i] < 0){
      for(n = 0; n < 3; n++){
    if(i >= 0 && i <= 2){
      if(grid[i][n][0] == ' '){
        ti = i;
        tn = wins[i];
      }
    }
    if(i >= 3 && i <= 5){
      if(grid[n][i][0] == ' '){
        ti = i;
        tn = wins[i];
      }
    }
    if(i == 6 && (grid[0][0][0] == ' ' || grid[1][1][0] == ' ' || grid[2][2][0] == ' ')){
      ti = i;
      tn = wins[i];
    }
    if(i == 7 && (grid[0][2][0] == ' ' || grid[1][1][0] == ' ' || grid[2][0][0] == ' ')){
      ti = i;
      tn = wins[i];
    }
      }
    }
  }
  return ti;
}
 
void computer_move(int *x, int *y){
  int tmp_x, tmp_y;
  int max, min, n;
 
  max = maxarrey();
  min = minarrey();
 
  if(wins[min] == -2 && wins[max] < 2){ /* Is the user winning?? */
    if(min >= 0 && min <= 2){
      tmp_x = min;
      for(n = 0; n < 3; n++){
    if(grid[tmp_x][n][0] == ' '){
      tmp_y = n;
    }
      }
    }
    else if(min >= 3 && min <= 5){
      tmp_y = min - 3;
      for(n = 0; n < 3; n++){
    if(grid[n][tmp_y][0] == ' '){
      tmp_x = n;
    }
    /*  else
        tmp_x = n; */
      }
      if(tmp_y == 2)
    tmp_x--;
    }
    else if(min == 6){
      if(grid[0][0][0] == ' '){
    tmp_x = 0;
    tmp_y = 0;
      }
      else if(grid[1][1][0] == ' '){
    tmp_x = 1;
    tmp_y = 1;
      }
      else if(grid[2][2][0] == ' '){
    tmp_x = 2;
    tmp_y = 2;
      }
    }
    else if(min == 7){
      if(grid[2][0][0] == ' '){
    tmp_x = 2;
    tmp_y = 0;
      }
      else if(grid[1][1][0] == ' '){
    tmp_x = 1;
    tmp_y = 1;
      }
      else if(grid[0][2][0] == ' '){
    tmp_x = 2;
    tmp_y = 2;
      }
    }
  }
  else{ /* User is not winning */
    if(max >= 0 && max <= 2){
      tmp_x = max;
      for(n = 0; n < 3; n++){
    if(grid[tmp_x][n][0] == ' '){
      tmp_y = n;
    }
      }
    }
    else if(max >= 2 && max <= 5){
      tmp_y = max;
      for(n = 0; n < 3; n++){
    if(grid[n][tmp_y][0] == ' '){
      tmp_x = n;
    }
      }
    }
    else if(max == 6){
      if(grid[2][0][0] == ' '){
    tmp_x = 0;
    tmp_y = 0;
      }
      else if(grid[1][1][0] == ' '){
    tmp_x = 1;
    tmp_y = 1;
      }
      else if(grid[0][2][0] == ' '){
    tmp_x = 2;
    tmp_y = 2;
      }
    }
    else if(max == 7){
      if(grid[0][0][0] == ' '){
    tmp_x = 0;
    tmp_y = 0;
      }
      else if(grid[1][1][0] == ' '){
    tmp_x = 1;
    tmp_y = 1;
      }
      else if(grid[2][2][0] == ' '){
    tmp_x = 2;
    tmp_y = 2;
      }
    }
  }
 
  *x = tmp_x;
  *y = tmp_y;
 
  wins[*x] = wins[*x] + 1;
  wins[(*y + 3)] = wins[(*y + 3)] + 1;
  if(*x == 1 && *y == 1){
    wins[6] += 1;
    wins[7] += 1;
  }
  if((*x == 0 && *y == 0) || (*x == 2 && *y == 2)){
    wins[6] += 1;
  }
  if((*x == 0 && *y == 2) || (*x == 2 && *y == 0)){
    wins[7] += 1;
  }
}
 
int make_move(char ch){
  int mov_x, mov_y;
 
  if(computer == 1 && ch == 'O'){
    computer_move(&mov_x, &mov_y);
    grid[mov_x][mov_y][0] = ch;
    return is_winner(ch);
  }
  else{
    printf("Enter x and y coordinates separated by a comma (ex. 1,2) or -1 to exit: ");
    scanf("%i,%i", &mov_x, &mov_y);
 
    if(mov_x == -1 && mov_y == -1)
      return EXIT;
 
    if((mov_x >= 0 && mov_x <= 2) && (mov_y >= 0 && mov_y <= 2)){
      if(grid[mov_x][mov_y][0] == ' '){
    grid[mov_x][mov_y][0] = ch;
 
    wins[mov_x] -= 1;
    wins[(mov_y + 3)] -= 1;
    if(mov_x == 1 && mov_y == 1){
      wins[6] -= 1;
      wins[7] -= 1;
    }
    if((mov_x == 0 && mov_y == 0) || (mov_x == 2 && mov_y == 2)){
      wins[6] -= 1;
    }
    if((mov_x == 0 && mov_y == 2) || (mov_x == 2 && mov_y == 0)){
      wins[7] -= 1;
    }
    return is_winner(ch);
      }
      else{
    return MOVE_MADE;
      }
    }
    else{
      return OUT_OF_RANGE;
    }
  }
  return is_winner(ch);
}
 
int main(int argc, char *argv[]){
  int move = 1;
  int winner = 0;
  int outcome;
  char sw;
 
  while((sw = getopt(argc, argv, "c")) != EOF){
    switch(sw){
    case 'c':
       computer = 1;
    }
  } 
 
  format_grid();
  print_grid();
 
  while(move < 9){
    while(move <= 9 && (outcome = make_move(player[move % 2])) == OK){
      print_grid();
      move++;
    }
    if(outcome == MOVE_MADE){
      printf("That move was already made. Try again.\n");
      continue;
    }
    if(outcome == OUT_OF_RANGE){
      printf("No such field. Out of range. Try again.\n");
      continue;
    }
    if(outcome == WINNER){
      print_grid();
      printf("the WINNER is: %c\n", player[move % 2]);
      return 0;
    }
    if(outcome == EXIT){
      return 0;
    }
    if(move >= 9){
      printf("No winner...\n");
      return 0;
    }
  }
}
