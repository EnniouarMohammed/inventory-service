package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.service.CreatorManager;
import ma.xproce.inventoryservice.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	@Autowired
	private CreatorManager creatorManager;
	@Autowired
	private VideoManager videoManager;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(){
		return args -> {
			//CREATING CREATORS
			Creator creator1 = new Creator();
			creator1.setName("MrBeast");
			creator1.setEmail("MrBeast@gmail.com");

			Creator creator2 = new Creator();
			creator2.setName("PewDiePie");
			creator2.setEmail("PewDiePie@gmail.com");

			Creator creator3 = new Creator();
			creator3.setName("The Weeknd");
			creator3.setEmail("TheWeeknd@gmail.com");

			creatorManager.addCreator(creator1);
			creatorManager.addCreator(creator2);
			creatorManager.addCreator(creator3);

			//CREATING VIDEOS
			Video video1 = new Video();
			video1.setName("7 Days Stranded On An Island");
			video1.setUrl("https://www.youtube.com/watch?v=erLbbextvlY");
			video1.setDescription("Follow and subscribe");
			video1.setDatePublication(new Date(2024,3,23));
			video1.setCreator(creator1);
			Video video2 = new Video();
			video2.setName("$1 vs $250,000,000 Private Island!");
			video2.setUrl("https://www.youtube.com/watch?v=krsBRQbOPQ4");
			video2.setDescription("Follow and subscribe");
			video2.setDatePublication(new Date(2024,3,8));
			video2.setCreator(creator1);

			Video video3 = new Video();
			video3.setName("Our Winter Trip!");
			video3.setUrl("https://www.youtube.com/watch?v=YWrFNoTXbKs");
			video3.setDescription("Follow and subscribe");
			video3.setDatePublication(new Date(2023,06,18));
			video3.setCreator(creator2);
			Video video4 = new Video();
			video4.setName("How a Reddit Post Changed my Life");
			video4.setUrl("https://www.youtube.com/watch?v=FcLaxJbWHZs");
			video4.setDescription("Follow and subscribe");
			video4.setDatePublication(new Date(2022,11,8));
			video4.setCreator(creator2);

			Video video5 = new Video();
			video5.setName("Die For You");
			video5.setUrl("https://www.youtube.com/watch?v=QLCpqdqeoII");
			video5.setDescription("Available now");
			video5.setDatePublication(new Date(2024,3,3));
			video5.setCreator(creator3);
			Video video6 = new Video();
			video6.setName("Call Out My Name");
			video6.setUrl("https://www.youtube.com/watch?v=rsEne1ZiQrk");
			video6.setDescription("Available now");
			video6.setDatePublication(new Date(2024,3,24));
			video6.setCreator(creator3);

			videoManager.addVideo(video1);
			videoManager.addVideo(video2);
			videoManager.addVideo(video3);
			videoManager.addVideo(video4);
			videoManager.addVideo(video5);
			videoManager.addVideo(video6);

			//SETTING VIDEOS TO CREATORS
			creator1.setVideos(List.of(video1,video2));
			creator2.setVideos(List.of(video3,video4));
			creator3.setVideos(List.of(video5,video6));

			creatorManager.updateCreator(creator1);
			creatorManager.updateCreator(creator2);
			creatorManager.updateCreator(creator3);

		};
	}
}
