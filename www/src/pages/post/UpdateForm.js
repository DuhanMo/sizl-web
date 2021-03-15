import React from 'react';
import { useEffect } from 'react';
import { useState } from 'react';
import { Button, Form } from 'react-bootstrap';

const UpdateForm = (props) => {
  const id = props.match.params.id;

  const [posts, setPosts] = useState({
    title: '',
    contetnt: '',
    author: '',
  });

  useEffect(() => {
    fetch('http://localhost:8080/api/v1/posts/' + id)
      .then((res) => res.json())
      .then((res) => {
        setPosts(res);
      });
  }, []);

  const changeValue = (e) => {
    setPosts({
      ...posts,
      [e.target.name]: e.target.value,
    });
  };

  const submitPosts = (e) => {
    e.preventDefault();

    fetch('http://localhost:8080/api/v1/posts/' + id, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
      },
      body: JSON.stringify(posts),
    })
      .then((res) => {
        if (res.status === 200) {
          return res.json();
        } else {
          return null;
        }
      })
      .then((res) => {
        if (res !== null) {
          props.history.push('/posts/' + id);
        } else {
          alert('게시글 수정에 실패하였습니다.');
        }
      });
  };

  return (
    <Form onSubmit={submitPosts}>
      <Form.Group>
        <Form.Label>제목</Form.Label>
        <Form.Control
          type="text"
          onChange={changeValue}
          name="title"
          value={posts.title}
        />
      </Form.Group>
      <Form.Group>
        <Form.Label>내용</Form.Label>
        <Form.Control
          type="text"
          onChange={changeValue}
          name="content"
          value={posts.content}
        />
      </Form.Group>
      <Form.Group>
        <Form.Label>작성자</Form.Label>
        <Form.Control
          type="text"
          onChange={changeValue}
          name="author"
          value={posts.author}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  );
};

export default UpdateForm;
