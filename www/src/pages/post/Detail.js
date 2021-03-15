import React, { useEffect } from 'react';
import { useState } from 'react';
import { Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const Detail = (props) => {
  const id = props.match.params.id;

  const [posts, setPosts] = useState({
    id: '',
    title: '',
    content: '',
    author: '',
  });

  useEffect(() => {
    fetch('http://localhost:8080/api/v1/posts/' + id)
      .then((res) => res.json())
      .then((res) => {
        setPosts(res);
      });
  }, []);

  const deletePosts = () => {
    fetch('http://localhost:8080/api/v1/posts/' + id, {
      method: 'DELETE',
    })
      .then((res) => res.text())
      .then((res) => {
        if (res === 'ok') {
          props.history.push('/');
        } else {
          alert('삭제 실패');
        }
      });
  };

  return (
    <div>
      <h1>책 상세보기</h1>
      <Link to={'/updateForm/' + id} className="btn btn-success">
        수정
      </Link>
      {'  '}
      <Button variant="danger" onClick={deletePosts}>
        삭제
      </Button>
      <hr />
      <h2>{posts.title}</h2>
      <h3>{posts.author}</h3>
      <h2>{posts.content}</h2>
    </div>
  );
};

export default Detail;
