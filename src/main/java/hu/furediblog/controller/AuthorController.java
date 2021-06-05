package hu.furediblog.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.furediblog.dto.BlogAuthorDto;
import hu.furediblog.service.AuthorService;
import hu.furediblog.service.EntryService;


@Controller
public class AuthorController{
	
	AuthorService authorService;
	EntryService entriesService;
	
	@Autowired(required=true)
	@Qualifier(value="entryService")
	public void setEntriesService(EntryService entriesService) {
		this.entriesService = entriesService;
	}

	@Autowired(required=true)
	@Qualifier(value="authorService")
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public String authors(Model model) {
		model.addAttribute("authors", authorService.listActiveAuthors());
		return "authors";
	}

	//entries az entriesService-bol authorId alapjan - pipa
	@RequestMapping(value = "/authorDetails", method = RequestMethod.GET)
	public String authorDetails(int id, Model model) {
		model.addAttribute("auhorsStories", entriesService.authorsEntries(id));
		model.addAttribute("author", authorService.getAuthorById(id));
		return "authorDetails";
	}

	@RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
	public ModelAndView addAuthor(String name, Model model) {
		BlogAuthorDto authorDto= new BlogAuthorDto();
		authorDto.setName(name);
		authorService.addAuthor(authorDto);
		return new ModelAndView("redirect:/furediBlog/authors");
	}

	//redirect - pipa
	@RequestMapping(value = "/editAuthor", method = RequestMethod.POST)
	public ModelAndView editAuthor(int id, String name, Model model) {
		BlogAuthorDto authorDto = new BlogAuthorDto();
		authorDto = authorService.getAuthorById(id);
		authorDto.setName(name);
		authorService.updateAuthor(authorDto);				
		return new ModelAndView("redirect:/furediBlog/authors");
	}
}
