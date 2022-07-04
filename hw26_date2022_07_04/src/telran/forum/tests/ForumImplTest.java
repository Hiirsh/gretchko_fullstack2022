package telran.forum.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.forum.model.Forum;
import telran.forum.model.ForumImpl;
import telran.forum.model.Post;

public class ForumImplTest {
  Forum forum;
  LocalDateTime now = LocalDateTime.now();
  Post[] posts = new Post[10];
  Comparator<Post> comp = (p1, p2) -> Integer.compare(p1.getPostId(), p2.getPostId());

  @BeforeEach
  void setUp() throws Exception {
    forum = new ForumImpl();
    posts[0] = new Post("author0", 0, "title0", "content0");
    posts[1] = new Post("author1", 1, "title1", "content1");
    posts[2] = new Post("author2", 2, "title2", "content2");
    posts[3] = new Post("author3", 3, "title3", "content3");
    posts[4] = new Post("author0", 4, "title4", "content4");
    posts[5] = new Post("author0", 5, "title5", "content5");
    posts[6] = new Post("author0", 6, "title6", "content6");
    posts[7] = new Post("author2", 7, "title7", "content7");
    posts[8] = new Post("author2", 8, "title8", "content8");
    for (int i = 0; i < 4; i++) {
      forum.addPost(posts[i]);
    }

  }

  @Test
  void testAddPost() {
    assertTrue(forum.addPost(posts[5]));
    assertTrue(forum.addPost(posts[6]));
    assertTrue(forum.addPost(posts[7]));
    assertFalse(forum.addPost(posts[3]));
  }

  @Test
  void testUpdatePost() {
    forum.updatePost(3, "content5");
    assertEquals(posts[5].getContent(), forum.getPostById(3).getContent());
  }

  @Test
  void testRemovePost() {
    forum.removePost(3);
    assertEquals(3, forum.size());
  }

  @Test
  void testSize() {
    assertEquals(4, forum.size());
  }

  @Test
  void testGetPostById() {
    assertEquals(posts[0], forum.getPostById(0));
  }

  @Test
  void testGetPostsByAuthor() {
    Post[] expected = { posts[0], posts[5], posts[6] };
    forum.addPost(posts[5]);
    forum.addPost(posts[6]);
    Post[] actual = forum.getPostsByAuthor("author0");
    Arrays.sort(actual, 0, actual.length, comp);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testGetPostsByAuthorInTimeRange() {
    posts[4].setDate(LocalDateTime.now().minusDays(2));
    posts[5].setDate(LocalDateTime.now().minusDays(3));
    posts[6].setDate(LocalDateTime.now().minusDays(5));
    forum.addPost(posts[4]);
    forum.addPost(posts[5]);
    forum.addPost(posts[6]);
    Post[] actual = forum.getPostsByAuthor("author0", LocalDateTime.now().minusDays(6).toLocalDate(),
        LocalDateTime.now().minusDays(1).toLocalDate());
    Arrays.sort(actual, 0, actual.length, comp);
    Post[] expected = { posts[4], posts[5], posts[6] };
    Arrays.sort(actual, 0, actual.length, comp);
    assertArrayEquals(expected, actual);
  }
}
