package hu.furediblog.mapper;

import hu.furediblog.dto.BlogEntryDto;
import hu.furediblog.model.BlogEntry;

public class EntryMapperImpl implements EntryMapper{

	public BlogEntry map(BlogEntryDto blogEntryDto) {
		BlogEntry blogEntry = new BlogEntry();
		blogEntry.setAuthor(new AuthorMapperImpl().map(blogEntryDto.getAuthor()));
		blogEntry.setContent(blogEntryDto.getContent());
		blogEntry.setId(blogEntryDto.getId());
		return blogEntry;
	}

	public BlogEntryDto map(BlogEntry entry) {
		BlogEntryDto blogEntryDto = new BlogEntryDto();
		blogEntryDto.setId(entry.getId());
		blogEntryDto.setContent(entry.getContent());
		blogEntryDto.setCreated(entry.getCreated());
		blogEntryDto.setAuthor(new AuthorMapperImpl().map(entry.getAuthor()));

		return blogEntryDto;
	}

}
