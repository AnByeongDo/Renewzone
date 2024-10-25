package com.example.app4.entity;

import com.example.app4.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="board")
public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String boardTitle;
    @Column
    private String boardWriter;
    @Column
    private String boardPass;
    @Column(length = 500)
    private String boardContents;
    @Column
    private int boardHits;

    public static BoardEntity toSaveEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        return boardEntity;
    }

    public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardDTO.getId());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        return boardEntity;
    }
}
