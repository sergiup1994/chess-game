public class PieceBishop extends Piece{
	
	public Piece[][] movebishop(Piece B, Piece h, Piece[][] t1){
		newstate = t1;
		newstate[h.cellx()][h.celly()] = new PieceBishop(B.type(), h.cellx(), h.celly());
		newstate[B.cellx()][B.celly()] = new EMPTY(0, B.cellx(), B.celly());
	
		return newstate;
	}

	

	public PieceBishop(int type, int i1, int j1) {
		super(type);
		ix = i1;
		jy = j1;
	}
	
	@Override
	public int cellx(){
		return ix;
	}
	
	@Override
	public int celly(){
		return jy;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	@Override
	public String imagefilename(){
		return imgname;
	}
	
	public String name = "Bishop";
	public String imgname = "bishop.png";
	private Piece[][] newstate;
	private int ix;
	private int jy;
}