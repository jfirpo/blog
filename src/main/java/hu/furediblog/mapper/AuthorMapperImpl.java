package hu.furediblog.mapper;

import org.springframework.stereotype.Component;

import hu.furediblog.dto.BlogAuthorDto;
import hu.furediblog.model.BlogAuthor;

@Component
public class AuthorMapperImpl implements AuthorMapper {


	public AuthorMapperImpl() {
		
	}
	
	public BlogAuthor map(BlogAuthorDto blogAuthorDto) {
		BlogAuthor  author = new BlogAuthor();
		author.setId(blogAuthorDto.getId());
		author.setName(blogAuthorDto.getName());

		// TODO Auto-generated method stub
		return author;
	}

	public BlogAuthorDto map(BlogAuthor author) {
		BlogAuthorDto blogAuthorDto = new BlogAuthorDto();
		blogAuthorDto.setId(author.getId());
		blogAuthorDto.setName(author.getName());
		
		// TODO Auto-generated method stub
		return blogAuthorDto;
	}

}
