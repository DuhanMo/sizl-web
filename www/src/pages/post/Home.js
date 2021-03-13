import React, { useEffect, useState } from 'react';
import PostItem from '../../components/PostItem';

const Home = () => {
  const [posts, setPosts] = useState([]);

  // 함수 실행시 최초 한번 실행되는 것 + 상태값이 변경될때마다 실행
  useEffect(() => {
    fetch('http://localhost:8080/posts')
      .then((res) => res.json())
      .then((res) => {
        setPosts(res);
      }); // 비동기 함수
  }, []);

  return (
    <div>
      {posts.map((posts) => (
        <PostItem key={posts.id} posts={posts} />
      ))}
    </div>
  );
};

export default Home;
