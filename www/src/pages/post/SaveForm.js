import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';

const SaveForm = (props) => {
  const [posts, setPosts] = useState({
    title: '',
    content: '',
    author: '',
  });

  const changeValue = (e) => {
    setPosts({
      ...posts,
      [e.target.name]: e.target.value,
    });
  };

  const submitPosts = (e) => {
    e.preventDefault();

    fetch('http://localhost:8080/api/v1/posts', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
      },
      body: JSON.stringify(posts),
    })
      .then((res) => {
        if (res.status === 201) {
          console.log(res);
          return res.json();
        } else {
          return null;
        }
      })
      .then((res) => {
        if (res !== null) {
          props.history.push('/');
        } else {
          alert('게시글 등록에 실패하였습니다.');
        }
      });
  };

  return (
    <Form onSubmit={submitPosts}>
      <Form.Group>
        <Form.Label>제목</Form.Label>
        <Form.Control
          type="text"
          placeholder="제목을 입력해주세요."
          onChange={changeValue}
          name="title"
        />
      </Form.Group>

      <Form.Group>
        <Form.Label>내용</Form.Label>
        <Form.Control
          type="text"
          placeholder="내용을 입력해주세요."
          onChange={changeValue}
          name="content"
        />
      </Form.Group>
      <Form.Group>
        <Form.Label>글쓴이</Form.Label>
        <Form.Control
          type="text"
          placeholder="글쓴이"
          onChange={changeValue}
          name="author"
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  );
};

export default SaveForm;
