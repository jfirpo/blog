package hu.furediblog.service;

import java.util.List;

import hu.furediblog.dto.BlogAuthorDto;

public interface AuthorService {
	public void addAuthor(BlogAuthorDto authorDto);
	public void updateAuthor(BlogAuthorDto authorDto);	
	public List<BlogAuthorDto> listAuthors();
	public BlogAuthorDto getAuthorById(int id);
	//public List<BlogEntry> authorsEntries(BlogAuthor author);
	public List<BlogAuthorDto> listActiveAuthors();
	
//	public void removeAuthor(int id);	
}
