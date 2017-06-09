import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;


public class CustomControl extends Control {

	public CustomControl(){
		pos = new Translate();
		setSkin(new CustomControlSkin(this));
		chessboard = new ChessBoard();
		getChildren().addAll(chessboard);
		
		// place the squares on the background 
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				chessboard.placeboard(i, j);
			}
		}
		
		// place the pieces on the board
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				chessboard.placeimages(i, j);
			}
		}
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				int x=(int)(event.getX());
				int y=(int)(event.getY());
				
				int hash=event.getTarget().hashCode();
				
				if(chessboard.click() == "true"){
				Piece[][] boardstate = chessboard.getState();
				targetpiece = chessboard.selectTarget(hash);
							
				// If pwan is selected do the following.
					if(piecesel.toString().equals("Pawn") && piecesel != null && targetpiece != null && piecesel.equals(targetpiece)==false){
						if(chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.LIGHTBLUE)==true || chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.RED)==true){
						boardstate = piecesel.movepawn(piecesel, targetpiece, boardstate);
						chessboard.setBoard(boardstate);
						chessboard.makemove(piecesel.cellx(), piecesel.celly(), targetpiece.cellx(), targetpiece.celly());
						chessboard.clicknull();
						chessboard.changeplayer();}
					}
					//king
					if(piecesel.toString().equals("King") && piecesel != null && targetpiece != null && piecesel.equals(targetpiece)==false){
						if(chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.LIGHTBLUE)==true || chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.RED)==true){
						boardstate = piecesel.moveking(piecesel, targetpiece, boardstate);
						chessboard.setBoard(boardstate);
						chessboard.makemove(piecesel.cellx(), piecesel.celly(), targetpiece.cellx(), targetpiece.celly());
						chessboard.clicknull();
						chessboard.changeplayer();}
					}
					//queen
					if(piecesel.toString().equals("Queen") && piecesel != null && targetpiece != null && piecesel.equals(targetpiece)==false){
						if(chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.LIGHTBLUE)==true || chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.RED)==true){
						boardstate = piecesel.movequeen(piecesel, targetpiece, boardstate);
						chessboard.setBoard(boardstate);
						chessboard.makemove(piecesel.cellx(), piecesel.celly(), targetpiece.cellx(), targetpiece.celly());
						chessboard.clicknull();
						chessboard.changeplayer();}
					}
					//rook
					if(piecesel.toString().equals("Rook") && piecesel != null && targetpiece != null && piecesel.equals(targetpiece)==false){
						if(chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.LIGHTBLUE)==true || chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.RED)==true){
						boardstate = piecesel.moverook(piecesel, targetpiece, boardstate);
						chessboard.setBoard(boardstate);
						chessboard.makemove(piecesel.cellx(), piecesel.celly(), targetpiece.cellx(), targetpiece.celly());
						chessboard.clicknull();
						chessboard.changeplayer();}
					}
					//knight
					if(piecesel.toString().equals("Knight") && piecesel != null && targetpiece != null && piecesel.equals(targetpiece)==false){
						if(chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.LIGHTBLUE)==true || chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.RED)==true){
						boardstate = piecesel.moveknight(piecesel, targetpiece, boardstate);
						chessboard.setBoard(boardstate);
						chessboard.makemove(piecesel.cellx(), piecesel.celly(), targetpiece.cellx(), targetpiece.celly());
						chessboard.clicknull();
						chessboard.changeplayer();}
					}
					//bishop
					if(piecesel.toString().equals("Bishop") && piecesel != null && targetpiece != null && piecesel.equals(targetpiece)==false){
						if(chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.LIGHTBLUE)==true || chessboard.getFill(targetpiece.cellx(), targetpiece.celly(), Color.RED)==true){
						boardstate = piecesel.movebishop(piecesel, targetpiece, boardstate);
						chessboard.setBoard(boardstate);
						chessboard.makemove(piecesel.cellx(), piecesel.celly(), targetpiece.cellx(), targetpiece.celly());
						chessboard.clicknull();
						chessboard.changeplayer();}
					}
					else{
					chessboard.clicknull();
					chessboard.clearhighlights();
					}
					chessboard.clearhighlights();
				}
				
				if(chessboard.click() == "false"){
				piecesel = chessboard.selectPiece(hash);
				
				if(piecesel != null && piecesel.toString() != "Empty"){
				chessboard.clicktrue();
				chessboard.validMoves(piecesel);}
				}
				
				
				if(chessboard.click() == "null"){
					chessboard.clickfalse();
				}
				
			}
		});
		
	}
	
	@Override
	public void resize(double width, double height){
		super.resize(width, height);
		chessboard.resize(width, height);
	}
	
	@Override
	public void relocate(double x, double y){
		super.relocate(x, y);
		pos.setX(x);
		pos.setY(x);
	}
	
	private Piece piecesel;
	private ChessBoard chessboard;
	private Translate pos;
	private Piece targetpiece;
	
}