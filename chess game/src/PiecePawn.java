public class PiecePawn extends Piece {
	public Piece[][] movepawn(Piece p, Piece d, Piece[][] t1){
		newstate = t1;
		firstmove = false;
		newstate[d.cellx()][d.celly()] = new PiecePawn(p.type(), d.cellx(), d.celly(), firstmove);
		newstate[p.cellx()][p.celly()] = new EMPTY(0, p.cellx(), p.celly());
		return newstate;
	}
	
	
	public PiecePawn(int type, int i1, int j1, boolean bl) {
		super(type);
		ix = i1;
		jy = j1;
		firstmove = bl;
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
	
	@Override
	public boolean firstmove(){
		return firstmove;
	}
	boolean firstmove;
	public String name = "Pawn";
	public String imgname = "pawn.png";
	private Piece[][] newstate;
	private int ix;
	private int jy;
	
}