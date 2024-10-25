package com.example.app4.dto;

import com.example.app4.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private String boardPass;
    private int boardHits;
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;

    public static  BoardDTO toBoardDTO(BoardEntity boardEntity){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardPass(boardEntity.getBoardPass());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardCreatedTime(boardEntity.getCreatedTime());
        boardDTO.setBoardUpdatedTime(boardEntity.getUpdatedTime());
        return boardDTO;
    }
}

