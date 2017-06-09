import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.transform.Translate;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessBoard extends Pane {
	
	//private fields
	
	
	public String click(){
		return clicklogic;
	}
	
	public void clicktrue(){
	clicklogic = "true";
	}
	
	public void clickfalse(){
	clicklogic = "false";
	}
	
	public void clicknull(){
	clicklogic = "null";
	}
	@Override
	public void resize(double width, double height){
		super.resize(width, height);
		cell_width = width/8;
		cell_height = height/8;
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				board[i][j].resize(i*cell_width, j*cell_height);
				board[i][j].relocate(i*cell_width, j*cell_height);
				board[i][j].setWidth(cell_width);
				board[i][j].setHeight(cell_height);
			}
		}
		
		for(int j = 0; j < 8; j++){
			for(int i = 0; i < 8; i++){
				// Black Royalty
				if(j == 0){
				imageviews[i][j].resize(cell_width/8, cell_height/8);
				imageviews[i][j].relocate(i*cell_width, j*cell_height);
				imageviews[i][j].setTranslateX(board[i][j].getWidth() / 8);
				imageviews[i][j].setFitWidth(cell_width/1);
				imageviews[i][j].setFitHeight(cell_height/1);
				
				}
				
				//White Royalty
				else if(j == 7){
				imageviews[i][j].resize(cell_width/8, cell_height/8);
				imageviews[i][j].relocate(i*cell_width, j*cell_height);
				imageviews[i][j].setTranslateX(board[i][j].getWidth() / 8);
				imageviews[i][j].setFitWidth(cell_width/1);
				imageviews[i][j].setFitHeight(cell_height/1);
				
				}
				
				else{
				imageviews[i][j].resize(cell_width/8, cell_height/8);
				imageviews[i][j].relocate(i*cell_width, j*cell_height);
				imageviews[i][j].setFitWidth(cell_width/1);
				imageviews[i][j].setFitHeight(cell_height/1);
				imageviews[i][j].setTranslateX(board[i][j].getWidth() / 8);	
				}
			}
		}
	}
	
public ChessBoard() {
	
	pos = new Translate();
	
	// Declares new board
	board = new Rectangle[boardWidth][boardHeight];
	
	// Initializes new board
	for(int x=0; x < 8; x++){
		for(int j=0; j < 8; j++){
			board[x][j] = new Rectangle();
			board[x][j].setWidth(50);
			board[x][j].setHeight(50);
			board[x][j].setFill(Color.TRANSPARENT);
			
		}
	}
	
	// Generates colours for the chessboard backgrounds
	for(int x=0; x < 8; x++){
		for(int j=0; j < 8; j++){
			if(x%2==0 && j%2==1){
			board[x][j].setFill(Color.GREY);
			}
			else if(x%2==0 && j%2==0){
			board[x][j].setFill(Color.BROWN);
			}
			else if(x%2==1 && j%2==1){
			board[x][j].setFill(Color.BROWN);
			}
			else if(x%2==1 && j%2==0){
			board[x][j].setFill(Color.GREY);
			}
		}
	}
	
	// New image array
	images = new Image[8][8];
		
		// first row of renders (black)
		images[7][0] = new Image("file:blackrook.png"); 
		images[6][0] = new Image("file:blackknight.png");
		images[5][0] = new Image("file:blackbishop.png"); 
		images[4][0] = new Image("file:blackking.png");
		images[3][0] = new Image("file:blackqueen.png"); 
		images[2][0] = new Image("file:blackbishop.png");
		images[1][0] = new Image("file:blackknight.png"); 
		images[0][0] = new Image("file:blackrook.png");
		// second row (black)
		images[7][1] = new Image("file:blackpawn.png"); 
		images[6][1] = new Image("file:blackpawn.png");
		images[5][1] = new Image("file:blackpawn.png"); 
		images[4][1] = new Image("file:blackpawn.png");
		images[3][1] = new Image("file:blackpawn.png"); 
		images[2][1] = new Image("file:blackpawn.png");
		images[1][1] = new Image("file:blackpawn.png"); 
		images[0][1] = new Image("file:blackpawn.png");
		
		// empty squares
		for(int x = 0; x < 8; x++){
			for(int y = 2; y < 6; y++){
				images[x][y] = new Image("file:empty.png");
			}
		}
		
		// third row (white)
		images[7][6] = new Image("file:whitepawn.png"); 
		images[6][6] = new Image("file:whitepawn.png");
		images[5][6] = new Image("file:whitepawn.png"); 
		images[4][6] = new Image("file:whitepawn.png");
		images[3][6] = new Image("file:whitepawn.png"); 
		images[2][6] = new Image("file:whitepawn.png");
		images[1][6] = new Image("file:whitepawn.png"); 
		images[0][6] = new Image("file:whitepawn.png");
		// fourth row of renders (white)
		images[7][7] = new Image("file:whiterook.png"); 
		images[6][7] = new Image("file:whiteknight.png");
		images[5][7] = new Image("file:whitebishop.png"); 
		images[4][7] = new Image("file:whiteking.png");
		images[3][7] = new Image("file:whitequeen.png"); 
		images[2][7] = new Image("file:whitebishop.png");
		images[1][7] = new Image("file:whiteknight.png"); 
		images[0][7] = new Image("file:whiterook.png");
		
		// Viewers for each image
		imageviews = new ImageView[8][8];
		
		// Initializes imageviewers and windows
		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8; y++){
				imageviews[x][y] = new ImageView();
			}
		}
		
		// Puts images into imageviewers
		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8; y++){
				imageviews[x][y].setImage(images[x][y]);
				imageviews[x][y].setFitWidth(50);
				imageviews[x][y].setFitHeight(80);
				imageviews[x][y].setPreserveRatio(true);
				imageviews[x][y].setSmooth(true);
				imageviews[x][y].setCache(true);
				imageviews[x][y].setTranslateX(board[x][y].getWidth() / 8);	
			}
		}
	
		//initialize the board: background, data structures, inital layout of pieces
		pieces = new Piece[boardWidth][boardHeight];
		
		// White Pieces
		pieces[7][7] = new PieceRook(PlayerWhite, 7, 7);
		pieces[6][7] = new PieceKnight(PlayerWhite, 6, 7);
		pieces[5][7] = new PieceBishop(PlayerWhite, 5, 7);
		pieces[4][7] = new PieceKing(PlayerWhite, 4, 7);
		pieces[3][7] = new PieceQueen(PlayerWhite, 3, 7);
		pieces[2][7] = new PieceBishop(PlayerWhite, 2, 7);
		pieces[1][7] = new PieceKnight(PlayerWhite, 1, 7);
		pieces[0][7] = new PieceRook(PlayerWhite, 0, 7);
		// Pawns
		pieces[7][6] = new PiecePawn(PlayerWhite, 7, 6, true);
		pieces[6][6] = new PiecePawn(PlayerWhite, 6, 6, true);
		pieces[5][6] = new PiecePawn(PlayerWhite, 5, 6, true);
		pieces[4][6] = new PiecePawn(PlayerWhite, 4, 6, true);
		pieces[3][6] = new PiecePawn(PlayerWhite, 3, 6, true);
		pieces[2][6] = new PiecePawn(PlayerWhite, 2, 6, true);
		pieces[1][6] = new PiecePawn(PlayerWhite, 1, 6, true);
		pieces[0][6] = new PiecePawn(PlayerWhite, 0 ,6, true);
		
		// Empty Pieces
		for(int x = 5; x > 1; x--){
			for(int j = 0; j < 8; j++){
				pieces[j][x] = new EMPTY(Empty, j, x);
			}
		}
		
		// Black Pieces
		pieces[7][0] = new PieceRook(PlayerBlack, 7, 0);
		pieces[6][0] = new PieceKnight(PlayerBlack, 6, 0);
		pieces[5][0] = new PieceBishop(PlayerBlack, 5, 0);
		pieces[4][0] = new PieceKing(PlayerBlack, 4, 0);
		pieces[3][0] = new PieceQueen(PlayerBlack, 3, 0);
		pieces[2][0] = new PieceBishop(PlayerBlack, 2, 0);
		pieces[1][0] = new PieceKnight(PlayerBlack, 1, 0);
		pieces[0][0] = new PieceRook(PlayerBlack, 0, 0);
		// Pawns
		pieces[7][1] = new PiecePawn(PlayerBlack, 7, 1, true);
		pieces[6][1] = new PiecePawn(PlayerBlack, 6, 1, true);
		pieces[5][1] = new PiecePawn(PlayerBlack, 5, 1, true);
		pieces[4][1] = new PiecePawn(PlayerBlack, 4, 1, true);
		pieces[3][1] = new PiecePawn(PlayerBlack, 3, 1, true);
		pieces[2][1] = new PiecePawn(PlayerBlack, 2, 1, true);
		pieces[1][1] = new PiecePawn(PlayerBlack, 1, 1, true);
		pieces[0][1] = new PiecePawn(PlayerBlack, 0, 1, true);
		
		current_player = 1;
}

	public void placeboard(final int i, final int j){
		getChildren().add(board[i][j]);
	}
	
	public void placeimages(final int i, final int j){
		getChildren().addAll(imageviews[i][j]);
	}
	
	// Returns stroke of board piece
	public boolean getFill(final int i, final int j, Paint color){
		if(board[i][j].getFill() == color){
			return true;
		}
		else return false;
	}
	
	//resize method
	
	
	@Override
	public void relocate(double x, double y){
		super.relocate(x, y);
		pos.setX(x);
		pos.setY(x);
	}
	
	//reset game method
	public void resetGame() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
			board[i][j] = null;
			getChildren().remove(pieces[i][j]);
			pieces[i][j] = null;
			}
		}
	}
	
	public Piece selectTarget(int hash){
		
		int i=0; int j=0;
		
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				if(imageviews[x][y].hashCode() == hash || board[x][y].hashCode() == hash){
				i = x; j = y;
				}
			}
		}
	
		int enemyplayer = 0;
		
		if(current_player == 1){
			enemyplayer = 2;
		}
		else{enemyplayer = 1;}
		
		if(winner == false){
			if(pieces[i][j].type() == 0 || pieces[i][j].type() == enemyplayer){
			return pieces[i][j];	
			}
		}
		return pieces[i][j];
	}
	
	//select piece method
	public Piece selectPiece(int hash){
		// Determine what piece was selected and if it can be selected
		int i=0; int j=0;
		
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				if(imageviews[x][y].hashCode() == hash){
				i = x; j = y;
				}
			}
		}

		if(current_player == 1 && winner == false){
			if(pieces[i][j].type() == 1){
				// If player has already selected the piece, deselect it
				if(board[i][j].getFill() == Color.LIGHTBLUE && pieceselect == true){
					if(i%2==0 && j%2==1){
					board[i][j].setFill(Color.GREY);
					pieceselect = false;
					}
					if(i%2==0 && j%2==0){
					board[i][j].setFill(Color.BROWN);
					pieceselect = false;						
					}
					if(i%2==1 && j%2==1){
					board[i][j].setFill(Color.BROWN);
					pieceselect = false;
					}
					if(i%2==1 && j%2==0){
					board[i][j].setFill(Color.GREY);
					pieceselect = false;
					}
				}
				// Otherwise select it and work out moves
				else{
				board[i][j].setFill(Color.LIGHTBLUE);
				pieceselect = true;
				return pieces[i][j];
				}
			}
		}
		
		// If current player is black
			else{
			if(pieces[i][j].type() == 2){
				if(board[i][j].getFill() == Color.LIGHTBLUE && pieceselect == true){
						// Resets color
						if(i%2==0 && j%2==1){
						board[i][j].setFill(Color.GREY);
						pieceselect = false;						
						}
						if(i%2==0 && j%2==0){
						board[i][j].setFill(Color.BROWN);
						pieceselect = false;
						}
						if(i%2==1 && j%2==1){
						board[i][j].setFill(Color.BROWN);
						pieceselect = false;
						}
						if(i%2==1 && j%2==0){
						board[i][j].setFill(Color.GREY);
						pieceselect = false;
						}
				}
				else{
				board[i][j].setFill(Color.LIGHTBLUE);
				pieceselect = true;
				return pieces[i][j];
				}
			}
		}
		
		// Bloody java has to return something ..
		return null;
	}
	
	// Returns state of the chess board ..
	public Piece[][] getState(){
		return pieces;
	}
	
	public void setBoard(Piece[][] newboard){
		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8; y++){
				System.out.println(newboard[y][x]);
				pieces[x][y] = newboard[x][y];
				
			}
		}
	}
	
	public void hoverhighlight(int x, int y){
		int i=x; int j=y;
		// Set highlight color
		board[i][j].setFill(Color.BLACK);
	}
	
	public void clearhighlights(){
		for(int x=0; x < 8; x++){
			for(int j=0; j < 8; j++){
				board[x][j].setFill(Color.TRANSPARENT);
				if(x%2==0 && j%2==1){
				board[x][j].setFill(Color.GREY);
				}
				else if(x%2==0 && j%2==0){
				board[x][j].setFill(Color.BROWN);
				}
				else if(x%2==1 && j%2==1){
				board[x][j].setFill(Color.BROWN);
				}
				else if(x%2==1 && j%2==0){
				board[x][j].setFill(Color.GREY);
				}
			}
		}
	}
	
	
	public void changeplayer(){
		if(current_player == 1){current_player = 2;}
		else{current_player = 1;}
	}
	
	
	// Draw the move and remove highlights
	public void makemove(final int l, int k, int h, int g){
		Image empty = new Image("file:empty.png");
		String piece = " ";
		piece = "black";
		if(pieces[h][g].type() == 1){
		piece = "white";}
		piece = piece + pieces[h][g].imagefilename();
		Image newimage = new Image("file:"+piece);
		imageviews[h][g].setImage(newimage);
		imageviews[l][k].setImage(empty);
		// Remove highlight
		if(board[l][k].getFill() == Color.LIGHTBLUE && pieceselect == true){
			if(l%2==0 && k%2==1){
				board[l][k].setFill(Color.GREY);						
			}
			else if(l%2==0 && k%2==0){
				board[l][k].setFill(Color.BROWN);
			}
			else if(l%2==1 && k%2==1){
				board[l][k].setFill(Color.BROWN);
			}
			else if(l%2==1 && k%2==0){
				board[l][k].setFill(Color.GREY);
			}
		}
		else if(pieceselect == false){
		board[l][k].setFill(Color.LIGHTBLUE);
		pieceselect = true;
		}
	}

	public void validMoves(Piece p){
	//white pawns
		if(p.toString() == "Pawn" && p.type() == 1){
			// look at the first square to see if its clear
			if(p.celly()-1 > 0){ 
				if(pieces[p.cellx()][p.celly()-1].toString().equals("Empty")){
					board[p.cellx()][p.celly()-1].setFill(Color.LIGHTBLUE);
					}}
			if(p.firstmove() == true){
			// look at the two squares ahead to see if its clear
				if(pieces[p.cellx()][p.celly()-2].toString().equals("Empty") && pieces[p.cellx()][p.celly()-1].toString().equals("Empty")){
					board[p.cellx()][p.celly()-2].setFill(Color.LIGHTBLUE);
			}}
	
			// look at diagonally if the enemy is present 
			if(p.cellx()-1 > 0 && p.celly()-1 > 0){
			if(pieces[p.cellx()-1][p.celly()-1].type() == 2){
				board[p.cellx()-1][p.celly()-1].setFill(Color.RED);
			}}
		
			// look at the other side if the enemy is present
			if(p.cellx()+1 < 8 && p.celly()-1 > 0){
			if(pieces[p.cellx()+1][p.celly()-1].type() == 2){
				board[p.cellx()+1][p.celly()-1].setFill(Color.RED);
			}}
		}
			
		//black pawns
			if(p.toString() == "Pawn" && p.type() == 2){
				if(p.celly()+1 < 8){ 
				if(pieces[p.cellx()][p.celly()+1].toString().equals("Empty")){
					board[p.cellx()][p.celly()+1].setFill(Color.LIGHTBLUE);
				}}
				if(p.firstmove() == true){
		        if(pieces[p.cellx()][p.celly()+2].toString().equals("Empty") && pieces[p.cellx()][p.celly()+1].toString().equals("Empty")){
					board[p.cellx()][p.celly()+2].setFill(Color.LIGHTBLUE);
				}}
				if(p.cellx()-1 > 0 && p.cellx()+1 < 8 && p.celly()+1 > 0){
				if(pieces[p.cellx()-1][p.celly()+1].type() == 1){
					board[p.cellx()-1][p.celly()+1].setFill(Color.RED);
				}}
				if(p.cellx()+1 < 8 && p.cellx()-1 > 0 && p.celly()+1 > 0){
				if(pieces[p.cellx()+1][p.celly()+1].type() == 1){
					board[p.cellx()+1][p.celly()+1].setFill(Color.RED);
				}}
			}
		
		    //white Rook
			if(p.toString() == "Rook" && p.type() == 1){	
				//look ahead
				for(int y = p.celly()-1; y >= 0; y--){
					if(pieces[p.cellx()][y].toString().equals("Empty")){
					board[p.cellx()][y].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[p.cellx()][y].type()==2){
					board[p.cellx()][y].setFill(Color.RED);
					y=0;
					}
					if(y!=0 && pieces[p.cellx()][y].type()==1){
					y=0;
					}
				}
				// Look at the right side
				for(int x = p.cellx()+1; x < 8; x++){
					if(pieces[x][p.celly()].toString().equals("Empty")){
					board[x][p.celly()].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[x][p.celly()].type()==2){
					board[x][p.celly()].setFill(Color.RED);
					x=8;
					}
					if(x!=8 && pieces[x][p.celly()].type()==1){
					x=8;
					}
				}
				// Look at the left side
				for(int x = p.cellx()-1; x >= 0; x--){
					if(pieces[x][p.celly()].toString().equals("Empty")){
					board[x][p.celly()].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][p.celly()].type()==2){
					board[x][p.celly()].setFill(Color.RED);
					x = 0;
					}
					if(x!=0 && pieces[x][p.celly()].type()==1){
					x = 0;
					}
				}
				
				// Look Down
				for(int y = p.celly()+1; y < 8; y++){
					if(pieces[p.cellx()][y].toString().equals("Empty")){
					board[p.cellx()][y].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[p.cellx()][y].type()==2){
					board[p.cellx()][y].setFill(Color.RED);
					y=8;
					}
					if(y!=8 && pieces[p.cellx()][y].type()==1 && y!=8){
					y=8;
					}
				}
			}
			
			//blackrook
			if(p.toString() == "Rook" && p.type() == 2){
				for(int y = p.celly()-1; y >= 0; y--){
					if(pieces[p.cellx()][y].toString().equals("Empty")){
					board[p.cellx()][y].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[p.cellx()][y].type()==1){
					board[p.cellx()][y].setFill(Color.RED);
					y=0;
					}
					if(y!=0 && pieces[p.cellx()][y].type()==2){
					y=0;
					}
				}
				for(int x = p.cellx()+1; x < 8; x++){
					if(pieces[x][p.celly()].toString().equals("Empty")){
					board[x][p.celly()].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[x][p.celly()].type()==1){
					board[x][p.celly()].setFill(Color.RED);
					x=8;
					}
					if(x!=8 && pieces[x][p.celly()].type()==2){
					x=8;
					}
				}
				for(int x = p.cellx()-1; x >= 0; x--){
					if(pieces[x][p.celly()].toString().equals("Empty")){
					board[x][p.celly()].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][p.celly()].type()==1){
					board[x][p.celly()].setFill(Color.RED);
					x=0;
					}
					if(x!=0 && pieces[x][p.celly()].type()==2){
					x=0;
					}
				}
				for(int y = p.celly()+1; y < 8; y++){
					if(pieces[p.cellx()][y].toString().equals("Empty")){
					board[p.cellx()][y].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[p.cellx()][y].type()==1){
					board[p.cellx()][y].setFill(Color.RED);
					y=8;
					}
					if(y!=8 && pieces[p.cellx()][y].type()==2){
					y=8;
					}
				}
			}
	
			//whitebishop
			if(p.toString() == "Bishop" && p.type() == 1){
				// Look ahead
				for(int y=p.celly()-1, x=p.cellx()-1; y >= 0 && x >= 0; y--,x--){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==2){
					board[x][y].setFill(Color.RED);
					x=0;y=0;
					}
					if(x!=0 && y!=0 && pieces[x][y].type()==1){
					x=0;y=0;
					}
				}
				for(int y=p.celly()-1, x=p.cellx()+1; y >= 0 && x < 8; y--,x++){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==2){
					board[x][y].setFill(Color.RED);
					x=8;y=0;
					}
					if(x!=8 && y!=0 && pieces[x][y].type()==1){
					x=8;y=0;
					}
				}
				
				// Look down on the left side
				for(int y=p.celly()+1, x=p.cellx()-1; y < 8 && x >= 0; y++,x--){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==2){
					board[x][y].setFill(Color.RED);
					x=0;y=8;
					}
					if(x!=0 && y!=8 && pieces[x][y].type()==1){
					x=0;y=8;
					}
				}
				
				// Look down on the right side
				for(int y=p.celly()+1, x=p.cellx()+1; y < 8 && x < 8; y++,x++){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==2){
					board[x][y].setFill(Color.RED);
					x=8;y=8;
					}
					if(x!=8 && y!=8 && pieces[x][y].type()==1){
					x=8;y=8;
					}
				}
			}
			//blackbishop
			if(p.toString() == "Bishop" && p.type() == 2){
				for(int y=p.celly()-1, x=p.cellx()-1; y >= 0 && x >= 0; y--,x--){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==1){
					board[x][y].setFill(Color.RED);
					x=0;y=0;
					}
					if(x!=0 && y!=0 && pieces[x][y].type()==2){
					x=0;y=0;
					}
				}
				for(int y=p.celly()-1, x=p.cellx()+1; y >= 0 && x < 8; y--,x++){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==1){
					board[x][y].setFill(Color.RED);
					x=8;y=0;
					}
					if(x!=8 && y!=0 && pieces[x][y].type()==2){
					x=8;y=0;
					}
				}
				for(int y=p.celly()+1, x=p.cellx()-1; y < 8 && x >= 0; y++,x--){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==1){
					board[x][y].setFill(Color.RED);
					x=0;y=8;
					}
					if(x!=0 && y!=8 && pieces[x][y].type()==2){
					x=0;y=8;
					}
				}
				for(int y=p.celly()+1, x=p.cellx()+1; y < 8 && x < 8; y++,x++){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==1){
					board[x][y].setFill(Color.RED);
					x=8;y=8;
					}
					if(x!=8 && y!=8 && pieces[x][y].type()==2){
					
					x=8;y=8;
					}
				}
			}
	
			//white knight
			if(p.toString() == "Knight" && p.type() == 1){
				// look left and ahead
				if(p.cellx()-1 >= 0 && p.celly()-2 >= 0){				
					if(pieces[p.cellx()-1][p.celly()-2].toString().equals("Empty")){
						board[p.cellx()-1][p.celly()-2].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()-1][p.celly()-2].type()==2){
						board[p.cellx()-1][p.celly()-2].setFill(Color.RED);
						}
				}
				if(p.cellx()-2 >= 0 && p.celly()-1 >= 0){			
					if(pieces[p.cellx()-2][p.celly()-1].toString().equals("Empty")){
						board[p.cellx()-2][p.celly()-1].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()-2][p.celly()-1].type()==2){
						board[p.cellx()-2][p.celly()-1].setFill(Color.RED);
						
					}
				}
				// look right and ahead
				if(p.cellx()+1 < 8 && p.celly()-2 >= 0){				
					if(pieces[p.cellx()+1][p.celly()-2].toString().equals("Empty")){
						board[p.cellx()+1][p.celly()-2].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()+1][p.celly()-2].type()==2){
						board[p.cellx()+1][p.celly()-2].setFill(Color.RED);
					}
				}
				if(p.cellx()+2 < 8 && p.celly()-1 >= 0){				
					if(pieces[p.cellx()+2][p.celly()-1].toString().equals("Empty")){
						board[p.cellx()+2][p.celly()-1].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()+2][p.celly()-1].type()==2){
						board[p.cellx()+2][p.celly()-1].setFill(Color.RED);
					}
				}
				// down and right
				if(p.cellx()+1 < 8 && p.celly()+2 < 8){				
					if(pieces[p.cellx()+1][p.celly()+2].toString().equals("Empty")){
						board[p.cellx()+1][p.celly()+2].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()+1][p.celly()+2].type()==2){
						board[p.cellx()+1][p.celly()+2].setFill(Color.RED);
					}
				}
				if(p.cellx()+2 < 8 && p.celly()+1 < 8){				
					if(pieces[p.cellx()+2][p.celly()+1].toString().equals("Empty")){
						board[p.cellx()+2][p.celly()+1].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()+2][p.celly()+1].type()==2){
						board[p.cellx()+2][p.celly()+1].setFill(Color.RED);
					}
				}
				if(p.cellx()-1 >= 0 && p.celly()+2 < 8){				
					if(pieces[p.cellx()-1][p.celly()+2].toString().equals("Empty")){
						board[p.cellx()-1][p.celly()+2].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()-1][p.celly()+2].type()==2){
						board[p.cellx()-1][p.celly()+2].setFill(Color.RED);
					}
				}
				if(p.cellx()-2 >= 0 && p.celly()+1 < 8){				
					if(pieces[p.cellx()-2][p.celly()+1].toString().equals("Empty")){
						board[p.cellx()-2][p.celly()+1].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()-2][p.celly()+1].type()==2){
						board[p.cellx()-2][p.celly()+1].setFill(Color.RED);
					}
				}	
			}
			
			//blackknight
			if(p.toString() == "Knight" && p.type() == 2){
				if(p.cellx()-1 >= 0 && p.celly()-2 >= 0){				
					if(pieces[p.cellx()-1][p.celly()-2].toString().equals("Empty")){
						board[p.cellx()-1][p.celly()-2].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()-1][p.celly()-2].type()==1){
						board[p.cellx()-1][p.celly()-2].setFill(Color.RED);
					}
				}
				if(p.cellx()-2 >= 0 && p.celly()-1 >= 0){				
					if(pieces[p.cellx()-2][p.celly()-1].toString().equals("Empty")){
						board[p.cellx()-2][p.celly()-1].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()-2][p.celly()-1].type()==1){
						board[p.cellx()-2][p.celly()-1].setFill(Color.RED);
					}
				}
				if(p.cellx()+1 < 8 && p.celly()-2 >= 0){				
					if(pieces[p.cellx()+1][p.celly()-2].toString().equals("Empty")){
						board[p.cellx()+1][p.celly()-2].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()+1][p.celly()-2].type()==1){
						board[p.cellx()+1][p.celly()-2].setFill(Color.RED);
					}
				}
				if(p.cellx()+2 < 8 && p.celly()-1 >= 0){				
					if(pieces[p.cellx()+2][p.celly()-1].toString().equals("Empty")){
						board[p.cellx()+2][p.celly()-1].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()+2][p.celly()-1].type()==1){
						board[p.cellx()+2][p.celly()-1].setFill(Color.RED);
					}
				}
				if(p.cellx()+1 < 8 && p.celly()+2 < 8){				
					if(pieces[p.cellx()+1][p.celly()+2].toString().equals("Empty")){
						board[p.cellx()+1][p.celly()+2].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()+1][p.celly()+2].type()==1){
						board[p.cellx()+1][p.celly()+2].setFill(Color.RED);
					}
				}
				if(p.cellx()+2 < 8 && p.celly()+1 < 8){				
					if(pieces[p.cellx()+2][p.celly()+1].toString().equals("Empty")){
						board[p.cellx()+2][p.celly()+1].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()+2][p.celly()+1].type()==1){
						board[p.cellx()+2][p.celly()+1].setFill(Color.RED);
					}
				}
				if(p.cellx()-1 >= 0 && p.celly()+2 < 8){				
					if(pieces[p.cellx()-1][p.celly()+2].toString().equals("Empty")){
						board[p.cellx()-1][p.celly()+2].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()-1][p.celly()+2].type()==1){
						board[p.cellx()-1][p.celly()+2].setFill(Color.RED);
					}
				}
				if(p.cellx()-2 >= 0 && p.celly()+1 < 8){				
					if(pieces[p.cellx()-2][p.celly()+1].toString().equals("Empty")){
						board[p.cellx()-2][p.celly()+1].setFill(Color.LIGHTBLUE);
					}
					if(pieces[p.cellx()-2][p.celly()+1].type()==1){
						board[p.cellx()-2][p.celly()+1].setFill(Color.RED);
					}
				}
				
			}
			
			
		//white king
			if(p.toString() == "King" && p.type() == 1){
				// look ahead
				if(p.celly()-1 >= 0){
					if(pieces[p.cellx()][p.celly()-1].toString().equals("Empty")){
						board[p.cellx()][p.celly()-1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()][p.celly()-1].type()==2){
						board[p.cellx()][p.celly()-1].setFill(Color.RED);
						}
					}
				// look at the right side
				if(p.celly()-1 >= 0 && p.cellx()+1 < 8){
					if(pieces[p.cellx()+1][p.celly()-1].toString().equals("Empty")){
						board[p.cellx()+1][p.celly()-1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()+1][p.celly()-1].type()==2){
						board[p.cellx()+1][p.celly()-1].setFill(Color.RED);
						}
					}
				
				// look at the left side
				if(p.celly()-1 >= 0 && p.cellx()-1 >= 0){
					if(pieces[p.cellx()-1][p.celly()-1].toString().equals("Empty")){
						board[p.cellx()-1][p.celly()-1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()-1][p.celly()-1].type()==2){
						board[p.cellx()-1][p.celly()-1].setFill(Color.RED);
						}
					}
				if(p.cellx()-1 >= 0){
					if(pieces[p.cellx()-1][p.celly()].toString().equals("Empty")){
						board[p.cellx()-1][p.celly()].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()-1][p.celly()].type()==2){
						board[p.cellx()-1][p.celly()].setFill(Color.RED);
						}
					}
				
				if(p.cellx()+1 < 8){
					if(pieces[p.cellx()+1][p.celly()].toString().equals("Empty")){
						board[p.cellx()+1][p.celly()].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()+1][p.celly()].type()==2){
						board[p.cellx()+1][p.celly()].setFill(Color.RED);
						}
				
				// look at the bottom
				if(p.celly()+1 < 8){
					if(pieces[p.cellx()][p.celly()+1].toString().equals("Empty")){
						board[p.cellx()][p.celly()+1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()][p.celly()+1].type()==2){
						board[p.cellx()][p.celly()+1].setFill(Color.RED);
						}
					}
				
				// Down and left
				if(p.celly()+1 < 8 && p.cellx()-1 >= 0){
					if(pieces[p.cellx()-1][p.celly()+1].toString().equals("Empty")){
						board[p.cellx()-1][p.celly()+1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()-1][p.celly()+1].type()==2){
						board[p.cellx()-1][p.celly()+1].setFill(Color.RED);
						}
					}
				
				// Down and right
				if(p.celly()+1 < 8 && p.cellx()+1 < 8){
					if(pieces[p.cellx()+1][p.celly()+1].toString().equals("Empty")){
						board[p.cellx()+1][p.celly()+1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()+1][p.celly()+1].type()==2){
						board[p.cellx()+1][p.celly()+1].setFill(Color.RED);
						}
					}	
				}
			
			//black king
			if(p.toString() == "King" && p.type() == 2){
				if(p.celly()-1 >= 0){
					if(pieces[p.cellx()][p.celly()-1].toString().equals("Empty")){
						board[p.cellx()][p.celly()-1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()][p.celly()-1].type()==1){
						board[p.cellx()][p.celly()-1].setFill(Color.RED);
						}
					}
				if(p.celly()-1 >= 0 && p.cellx()+1 < 8){
					if(pieces[p.cellx()+1][p.celly()-1].toString().equals("Empty")){
						board[p.cellx()+1][p.celly()-1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()+1][p.celly()-1].type()==1){
						board[p.cellx()+1][p.celly()-1].setFill(Color.RED);
						}
					}
				if(p.celly()-1 >= 0 && p.cellx()-1 >= 0){
					if(pieces[p.cellx()-1][p.celly()-1].toString().equals("Empty")){
						board[p.cellx()-1][p.celly()-1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()-1][p.celly()-1].type()==1){
						board[p.cellx()-1][p.celly()-1].setFill(Color.RED);
						}
					}
				if(p.cellx()-1 >= 0){
					if(pieces[p.cellx()-1][p.celly()].toString().equals("Empty")){
						board[p.cellx()-1][p.celly()].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()-1][p.celly()].type()==1){
						board[p.cellx()-1][p.celly()].setFill(Color.RED);
						}
					}
				if(p.cellx()+1 < 8){
					if(pieces[p.cellx()+1][p.celly()].toString().equals("Empty")){
						board[p.cellx()+1][p.celly()].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()+1][p.celly()].type()==1){
						board[p.cellx()+1][p.celly()].setFill(Color.RED);
						}
					}
				if(p.celly()+1 < 8){
					if(pieces[p.cellx()][p.celly()+1].toString().equals("Empty")){
						board[p.cellx()][p.celly()+1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()][p.celly()+1].type()==1){
						board[p.cellx()][p.celly()+1].setFill(Color.RED);
						}
					}
				if(p.celly()+1 < 8 && p.cellx()-1 >= 0){
					if(pieces[p.cellx()-1][p.celly()+1].toString().equals("Empty")){
						board[p.cellx()-1][p.celly()+1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()-1][p.celly()+1].type()==1){
						board[p.cellx()-1][p.celly()+1].setFill(Color.RED);
						}
					}
				if(p.celly()+1 < 8 && p.cellx()+1 < 8){
					if(pieces[p.cellx()+1][p.celly()+1].toString().equals("Empty")){
						board[p.cellx()+1][p.celly()+1].setFill(Color.LIGHTBLUE);
						}
					if(pieces[p.cellx()+1][p.celly()+1].type()==1){
						board[p.cellx()+1][p.celly()+1].setFill(Color.RED);
						}
					}	
				}
			//white queen
			if(p.toString() == "Queen" && p.type() == 1){
				// Look ahead and left
				for(int y=p.celly()-1, x=p.cellx()-1; y >= 0 && x >= 0; y--,x--){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==2){
					board[x][y].setFill(Color.RED);
					x=0;y=0;
					}
					if(x!=0 && y!=0 && pieces[x][y].type()==1){
					x=0;y=0;
					}
				}
				
				// Look ahead and right
				for(int y=p.celly()-1, x=p.cellx()+1; y >= 0 && x < 8; y--,x++){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==2){
					board[x][y].setFill(Color.RED);
					x=8;y=0;
					}
					if(x!=8 && y!=0 && pieces[x][y].type()==1){
					x=8;y=0;
					}
				}
				// Look down and left
				for(int y=p.celly()+1, x=p.cellx()-1; y < 8 && x >= 0; y++,x--){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==2){
					board[x][y].setFill(Color.RED);
					x=0;y=8;
					}
					if(x!=0 && y!=8 && pieces[x][y].type()==1){
					x=0;y=8;
					}
				}
				 //look down and right
				for(int y=p.celly()+1, x=p.cellx()+1; y < 8 && x < 8; y++,x++){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==2){
					board[x][y].setFill(Color.RED);
					x=8;y=8;
					}
					if(x!=8 && y!=8 && pieces[x][y].type()==1){
					x=8;y=8;
					}
				}
				for(int y = p.celly()-1; y >= 0; y--){
					if(pieces[p.cellx()][y].toString().equals("Empty")){
					board[p.cellx()][y].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[p.cellx()][y].type()==2){
					board[p.cellx()][y].setFill(Color.RED);
					y=0;
					}
					if(y!=0 && pieces[p.cellx()][y].type()==1){
					y=0;
					}
				}
				
				// Look Right side
				for(int x = p.cellx()+1; x < 8; x++){
					if(pieces[x][p.celly()].toString().equals("Empty")){
					board[x][p.celly()].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[x][p.celly()].type()==2){
					board[x][p.celly()].setFill(Color.RED);
					x=8;
					}
					if(x!=8 && pieces[x][p.celly()].type()==1){
					x=8;
					}
				}
				// Look Left side
				for(int x = p.cellx()-1; x >= 0; x--){
					if(pieces[x][p.celly()].toString().equals("Empty")){
					board[x][p.celly()].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][p.celly()].type()==2){
					board[x][p.celly()].setFill(Color.RED);
					x = 0;
					}
					if(x!=0 && pieces[x][p.celly()].type()==1){
					x = 0;
					}
				}
				
			    //look at the buttom
				for(int y = p.celly()+1; y < 8; y++){
					if(pieces[p.cellx()][y].toString().equals("Empty")){
					board[p.cellx()][y].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[p.cellx()][y].type()==2){
					board[p.cellx()][y].setFill(Color.RED);
					y=8;
					}
					if(y!=8 && pieces[p.cellx()][y].type()==1 && y!=8){
					y=8;
					}
				}
			}
			
			//black queen
			if(p.toString() == "Queen" && p.type() == 2){
				for(int y=p.celly()-1, x=p.cellx()-1; y >= 0 && x >= 0; y--,x--){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==1){
					board[x][y].setFill(Color.RED);
					x=0;y=0;
					}
					if(x!=0 && y!=0 && pieces[x][y].type()==2){
					x=0;y=0;
					}
				}
				for(int y=p.celly()-1, x=p.cellx()+1; y >= 0 && x < 8; y--,x++){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==1){
					board[x][y].setFill(Color.RED);
					x=8;y=0;
					}
					if(x!=8 && y!=0 && pieces[x][y].type()==2){
					x=8;y=0;
					}
				}
				for(int y=p.celly()+1, x=p.cellx()-1; y < 8 && x >= 0; y++,x--){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==1){
					board[x][y].setFill(Color.RED);
					x=0;y=8;
					}
					if(x!=0 && y!=8 && pieces[x][y].type()==2){
					x=0;y=8;
					}
				}
				for(int y=p.celly()+1, x=p.cellx()+1; y < 8 && x < 8; y++,x++){
					if(pieces[x][y].toString().equals("Empty")){
					board[x][y].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][y].type()==1){
					board[x][y].setFill(Color.RED);
					x=8;y=8;
					}
					if(x!=8 && y!=8 && pieces[x][y].type()==2){
					x=8;y=8;
					}
				}
				for(int y = p.celly()-1; y >= 0; y--){
					if(pieces[p.cellx()][y].toString().equals("Empty")){
					board[p.cellx()][y].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[p.cellx()][y].type()==1){
					board[p.cellx()][y].setFill(Color.RED);
					y=0;
					}
					if(y!=0 && pieces[p.cellx()][y].type()==2){
					y=0;
					}
				}
				for(int x = p.cellx()+1; x < 8; x++){
					if(pieces[x][p.celly()].toString().equals("Empty")){
					board[x][p.celly()].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[x][p.celly()].type()==1){
					board[x][p.celly()].setFill(Color.RED);
					x=8;
					}
					if(x!=8 && pieces[x][p.celly()].type()==2){
					x=8;
					}
				}
				for(int x = p.cellx()-1; x >= 0; x--){
					if(pieces[x][p.celly()].toString().equals("Empty")){
					board[x][p.celly()].setFill(Color.LIGHTBLUE);
					}
					if(pieces[x][p.celly()].type()==1){
					board[x][p.celly()].setFill(Color.RED);
					x = 0;
					}
					if(x!=0 && pieces[x][p.celly()].type()==2){
					x = 0;
					}
				}
				for(int y = p.celly()+1; y < 8; y++){
					if(pieces[p.cellx()][y].toString().equals("Empty")){
					board[p.cellx()][y].setFill(Color.LIGHTBLUE);	
					}
					if(pieces[p.cellx()][y].type()==1){
						board[p.cellx()][y].setFill(Color.RED);
					y=8;
					}
					if(y!=8 && pieces[p.cellx()][y].type()==2 && y!=8){
					y=8;
					}
				}
			}
	
			}	
			}
	private int boardWidth = 8;
	private int boardHeight = 8;
	
	private Piece[][] pieces;
	private Rectangle[][] board;
	private Image[][] images;
	private ImageView[][] imageviews;
	
	private double cell_width;
	private double cell_height;
	private int current_player=1;
	private String clicklogic="false";
	
	private final int PlayerWhite = 1;
	private final int PlayerBlack = 2;
	private final int Empty = 0;
	private boolean pieceselect = false;
	private boolean winner = false;
	
	private Translate pos;
}