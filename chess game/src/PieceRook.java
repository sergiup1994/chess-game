public class PieceRook extends Piece {
	public Piece[][] moverook(Piece R, Piece h, Piece[][] t1){
		newstate = t1;
		newstate[h.cellx()][h.celly()] = new PieceRook(R.type(), h.cellx(), h.celly());
		newstate[R.cellx()][R.celly()] = new EMPTY(0, R.cellx(), R.celly());
		return newstate;
	}
	

	public PieceRook(int type, int i1, int j1) {
		super(type);
		ix = i1;
		ij = j1;
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
		if(ij > 8){
		return 7;}
		
		if(ij < 0){
		return 0;}
		
		else{return ij;}
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	@Override
	public String imagefilename(){
		return imgname;
	}
	public String name = "Rook";
	public String imgname = "rook.png";
	private Piece[][] newstate;
	private int ix;
	private int ij;
	

}