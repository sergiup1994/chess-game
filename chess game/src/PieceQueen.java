public class PieceQueen extends Piece {
	public Piece[][] movequeen(Piece Q, Piece h, Piece[][] t1){
		newstate = t1;
		newstate[h.cellx()][h.celly()] = new PieceQueen(Q.type(), h.cellx(), h.celly());
		newstate[Q.cellx()][Q.celly()] = new EMPTY(0, Q.cellx(), Q.celly());
		return newstate;
	}
	

	public PieceQueen(int type, int i1, int j1) {
		super(type);
		ix = i1;
		jy = j1;
	}
	
	@Override
	public int cellx(){
		if(ix > 8){
		return 7;}
		
		if(ix < 0){
		return 0;}
		
		else{return ix;}
	}
	
	@Override
	public int celly(){
		if(jy > 8){
		return 7;}
		
		if(jy < 0){
		return 0;}
		
		else{return jy;}
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	@Override
	public String imagefilename(){
		return imgname;
	}
	public String name = "Queen";
	public String imgname = "queen.png";
	private Piece[][] newstate;
	private int ix;
	private int jy;
	
}