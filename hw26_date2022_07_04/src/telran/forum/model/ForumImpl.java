package telran.forum.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.function.Predicate;

public class ForumImpl implements Forum {
  Post[] posts;
  int size;

  public ForumImpl() {
    posts = new Post[5];
  }

  @Override
  public boolean addPost(Post post) {
    if (post == null || getPostById(post.getPostId()) != null) {
      return false;
    }
    if (size + 1 == posts.length) {
      posts = Arrays.copyOf(posts, size * 2);
    }
    int index = Arrays.binarySearch(posts, 0, size, post);
    index = index < 0 ? -index - 1 : index;
    System.arraycopy(posts, index, posts, index + 1, size - index);
    posts[index] = post;
    size++;
    return true;
  }

  @Override
  public boolean removePost(int postId) {
    int index = getPostIndex(postId);
    if (index == -1) {
      return false;
    }
    System.arraycopy(posts, index + 1, posts, index, size - index - 1);
    posts[size] = null;
    size--;
    return true;
  }

  @Override
  public boolean updatePost(int postId, String newContent) {
    int index = getPostIndex(postId);
    if (index == -1) {
      return false;
    }
    posts[index].setContent(newContent);
    return true;
  }

  @Override
  public Post getPostById(int postId) {
    Post pattern = new Post(null, postId, null, null);
    for (int i = 0; i < size; i++) {
      if (posts[i].equals(pattern)) {
        return posts[i];
      }
    }
    return null;
  }

  @Override
  public Post[] getPostsByAuthor(String author) {
    return findPostsByPredicate(p -> p.getAuthor().equals(author));
  }

  @Override
  public Post[] getPostsByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
    Post[] temp = getPostsByAuthor(author);
    Post pattern = new Post(null, 0, null, null);
    pattern.setDate(dateFrom.atStartOfDay());
    int from = Arrays.binarySearch(temp, 0, temp.length, pattern);
    while (from >= 0) {
      from = Arrays.binarySearch(temp, 0, from, pattern);
    }
    from = from < 0 ? -from - 1 : from;
    pattern.setDate(LocalDateTime.of(dateTo, LocalTime.MAX));
    int to = Arrays.binarySearch(temp, 0, temp.length, pattern);
    while (to >= 0) {
      to = Arrays.binarySearch(temp, to, size, pattern);
    }
    to = to < 0 ? -to - 1 : to;
    return Arrays.copyOfRange(temp, from, to);
  }

  @Override
  public int size() {
    return size;
  }

  private Post[] findPostsByPredicate(Predicate<Post> predicate) {
    Post[] res = new Post[size];
    int j = 0;
    for (int i = 0; i < size; i++) {
      if (predicate.test(posts[i])) {
        res[j++] = posts[i];
      }
    }
    return Arrays.copyOf(res, j);
  }

  private int getPostIndex(int postId) {
    for (int i = 0; i < size; i++) {
      if (posts[i].getPostId() == postId) {
        return i;
      }
    }
    return -1;
  }
}
