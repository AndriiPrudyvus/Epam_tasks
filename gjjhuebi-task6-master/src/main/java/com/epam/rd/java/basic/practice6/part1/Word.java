package com.epam.rd.java.basic.practice6.part1;

import java.util.Objects;

public class Word implements Comparable<Word> {

	private String content;
	
	private int frequency;
	
	public Word() {
    }

    public Word(String content) {
        this.content = content;
    }

    public Word(String content, int frequency) {
        this.content = content;
        this.frequency = frequency;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getContent() {
        return content;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(Word o) {
        return content.compareTo(o.content);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return frequency == word.frequency &&
                Objects.equals(content, word.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, frequency);
    }

    @Override
    public String toString() {
        return content + " : " + frequency;
    }
}
