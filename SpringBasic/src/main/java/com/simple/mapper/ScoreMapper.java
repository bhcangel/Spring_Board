package com.simple.mapper;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreMapper {
	
	public int scoreRegist(ScoreVO vo);		//���
	public ArrayList<ScoreVO> scoreList();	//���
	public void scoreDelete(int num);		//����
	
	
	
}
