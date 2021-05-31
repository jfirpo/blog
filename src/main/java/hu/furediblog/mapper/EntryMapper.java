package hu.furediblog.mapper;

import hu.furediblog.dto.BlogEntryDto;
import hu.furediblog.model.BlogEntry;

public interface EntryMapper {
	BlogEntry map(BlogEntryDto blogEntryDto);
	BlogEntryDto map(BlogEntry entry);
}
