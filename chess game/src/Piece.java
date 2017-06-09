
public abstract class Piece {
	public int cellx(){
		// Bounds correction
		if(ix > 8){
		return 7;}
		
		if(ix < 0){
		return 0;}
		
		else{return ix;}
	}
	
	public int celly(){
		if(jy > 8){
		return 7;}
		
		if(ix < 0){
		return 0;}
		
		else{return jy;}
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	public String imagefilename(){
		return imgname;
	}
	
	public Piece(int type){
		this.type=type;
	}
	
	public boolean firstmove(){
		return firstmove;
	}
	
	public int type(){
		if(type == 1){
		return 1;
		}
		if(type == 2){
		return 2;
		}
		else return 0;
	}
	
	public Piece[][] movepawn(Piece selectedpiece, Piece targetpiece, Piece[][] boardstate) {
		// TODO Auto-generated method stub
		
		return newstate;
	}
	public Piece[][] moverook(Piece selectedpiece, Piece targetpiece, Piece[][] boardstate) {
		// TODO Auto-generated method stub
		return newstate;
	}
	
	
	public Piece[][] moveking(Piece selectedpiece, Piece targetpiece, Piece[][] boardstate) {
		// TODO Auto-generated method stub
		return newstate;
	}

	
	public Piece[][] movebishop(Piece selectedpiece, Piece targetpiece, Piece[][] boardstate) {
		// TODO Auto-generated method stub
		return newstate;
	}
	public Piece[][] moveknight(Piece selectedpiece, Piece targetpiece, Piece[][] boardstate) {
		// TODO Auto-generated method stub
		return newstate;
	}
	public Piece[][] movequeen(Piece selectedpiece, Piece targetpiece, Piece[][] boardstate) {
		// TODO Auto-generated method stub
		return newstate;
	}

	
	private int type;
	private String name;
	private String imgname;
	private int ix;
	private int jy;
	private Piece[][] newstate;
	private boolean firstmove;

	
}