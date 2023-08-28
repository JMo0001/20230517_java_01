package kh.lclass.db1.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.lclass.db1.board.model.dao.BoardDao;
import kh.lclass.db1.board.model.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> selectList() throws Exception{
		return boardDao.selectList();
	}
	public BoardVo selectOne(int bno)throws Exception {
		return boardDao.selectOne(bno);
	}
	public int insert(BoardVo vo)throws Exception {
//		int nextval = boardDao.getNextVal();
//		boardDao.update(vo);
		BoardVo returnVo = boardDao.insert(vo);
		int result = returnVo.getBno();
		if(returnVo.getBno() == 0) {
//		if(returnVo.getAttachFileList()!=null && returnVo.getAttachFileList().size()>0){
//			boardDao.insertAttachiFileList(vo);
			
		}
		return result;
	}
	public int update(BoardVo vo) throws Exception{
		return boardDao.update(vo);
	}
	public int delete(int bno)throws Exception {
		return boardDao.delete(bno);
	}
}
