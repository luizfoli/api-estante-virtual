package com.luizfoli.apiestantevirtual.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroDTO {
	
    private String id;
    private String titulo;
    private String autor;
    private String publicador;
    private String descricao;
    private int avaliacao;
    @JsonProperty("data_publicacao") private String dataPublicacao;
    @JsonProperty("qtd_paginas") private int qtdPaginas;
    @JsonProperty("avalicao_media") private int avaliacaoMedia;
    @JsonProperty("link_image") private String linkImagem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String title) {
        this.titulo = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPublicador() {
        return publicador;
    }

    public void setPublicador(String publicador) {
        this.publicador = publicador;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public int getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public void setAvaliacaoMedia(int avaliacaoMedia) {
        this.avaliacaoMedia = avaliacaoMedia;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public void setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
    }

}
