package hu.furediblog.mapper;

import hu.furediblog.dto.BlogAuthorDto;
import hu.furediblog.model.BlogAuthor;

public interface AuthorMapper {
	BlogAuthor map(BlogAuthorDto blogAuthorDto);
	BlogAuthorDto map(BlogAuthor author);
}
