package dopeAgile;

public class Map {
    
    public enum mapSize { SMALL, MEDIUM, LARGE};
    
    private mapSize[][] board;
    
    public smallMap(){
      board = new mapSize[4][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = mapSize.SMALL;
            }
        }
    }
}
