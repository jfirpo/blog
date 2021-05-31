package hu.furediblog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.furediblog.dto.BlogAuthorDto;
import hu.furediblog.mapper.AuthorMapper;
import hu.furediblog.mapper.AuthorMapperImpl;
import hu.furediblog.model.BlogAuthor;
import hu.furediblog.model.dao.AuthorDao;

@Service
public class AuthorsServiceImpl implements AuthorService{
	private AuthorDao authorDao;
	AuthorMapper authorMapper = new AuthorMapperImpl();

	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}
	public List<BlogAuthorDto> listAuthors() {
		List<BlogAuthorDto> blogAuthorListDto = new ArrayList<BlogAuthorDto>();	
		for (BlogAuthor author : this.authorDao.listAuthors()) {
			BlogAuthorDto authorDto = authorMapper.map(author);
			blogAuthorListDto.add(authorDto);
		}
		return blogAuthorListDto;
	}

	public List<BlogAuthorDto> listActiveAuthors() {	
		List<BlogAuthorDto> blogActiveAuthorListDto = new ArrayList<BlogAuthorDto>();				
		for (BlogAuthor author : this.authorDao.listActiveAuthors()) {
			blogActiveAuthorListDto.add(authorMapper.map(author));
		} 
		
		return blogActiveAuthorListDto;
	}
	
	public BlogAuthorDto getAuthorById(int id) {
		return authorMapper.map(this.authorDao.getAuthorById(id));
	}
	
	
	public void addAuthor(BlogAuthorDto authorDto) {		
		this.authorDao.addAuthor(authorMapper.map(authorDto));		
	}

	public void updateAuthor(BlogAuthorDto authorDto){
		this.authorDao.updateAuthor(authorMapper.map(authorDto));		
	}
			
/// atviszem az enrtyServicebe.. Rakerdezni!!!!!!!!!!!!!!!!!
/*
	public List<BlogEntryDto> authorsEntries(Authors author) {
		List<Entries> entries = this.authorDao.getAuthorById(author.getId()).getEntries();
		//foreach -> authorMapper.map(author) -> add to new list
		return entries; // mappelt lista
		
	}
	
	public List<BlogEntry> authorsEntries(BlogAuthor author) {
		return authorDao.listauthorsEntries(author);
	}
*/
}
